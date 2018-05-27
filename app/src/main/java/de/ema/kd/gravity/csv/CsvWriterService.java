package de.ema.kd.gravity.csv;


import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.ema.kd.gravity.event.GravityEventListener;

public class CsvWriterService implements GravityEventListener{
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

    private String path = Environment.getExternalStorageDirectory().getAbsolutePath() +"/gravity" ;
    private OutputStreamWriter outWriter;
    private FileOutputStream fileOutputStream;

   public CsvWriterService(){
       File dir = new File(path);
       dir.mkdirs();
   }

    @Override
    public void onGravityChanged(float[] gravity) {
        String cvsFormat = String.format(Locale.GERMAN,"%s , %s , %s\n",Float.valueOf(gravity[0]).toString(),Float.valueOf(gravity[1]).toString(),Float.valueOf(gravity[2]).toString());

        try {
            outWriter.append(cvsFormat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPrepare(boolean writing){
        try {
            if(writing){
                openFile();
            }else{
                outWriter.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void openFile() throws IOException {
        File file = new File(path,dateFormat.format(new Date())+".csv");

        file.createNewFile();
        fileOutputStream = new FileOutputStream(file,true);
         outWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
    }
}
