package cn.com.tcsl.mvptest.ui.down;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wjx on 2016/7/23.
 */
public class DownModel implements DownContract.Model {
    @Override
    public File writeToSD(InputStream inputStream) {
        FileOutputStream os=null;
        File filePath=new File("/sdcard/Ticket");
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        File file=new File(filePath,"test.apk");
        try{

            os=new FileOutputStream(file);
            byte[] buffer=new byte[1024];
            int len;
            while((len=inputStream.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(os!=null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
