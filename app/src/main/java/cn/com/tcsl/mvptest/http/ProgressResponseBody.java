package cn.com.tcsl.mvptest.http;

import java.io.IOException;

import cn.com.tcsl.mvptest.http.interfaces.DownProgressListener;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by wu on 2016/7/20.
 */
public class ProgressResponseBody extends ResponseBody {
private DownProgressListener mProgressListener;
    private ResponseBody mResponseBody;
    private BufferedSource mBufferedSource;

    public ProgressResponseBody(DownProgressListener mProgressListener, ResponseBody mResponseBody) {
        this.mProgressListener = mProgressListener;
        this.mResponseBody = mResponseBody;
    }

    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    @Override
    public long contentLength() {
        return mResponseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if(mBufferedSource==null){
            mBufferedSource= Okio.buffer(source(mResponseBody.source()));
        }
        return mBufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            long nowSize=0l;
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long readSize = super.read(sink, byteCount);
                nowSize += (readSize != -1 ? readSize : 0);
                mProgressListener.update(nowSize, mResponseBody.contentLength(), readSize == -1);
                return readSize;
            }
        };
    }

}
