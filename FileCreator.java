package oop_dosya.berkakay;
/*
    Berk Akay
    05.04.2019
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileCreator {
    
    private String fileName;
    private String text;
    private Boolean method;
    private File file;
    private FileReader fileReader;
    private BufferedReader buffReader;
    private FileWriter fileWriter;
    private BufferedWriter buffWriter;
    
    class createAndWrite{
    //Constructor
     public  createAndWrite(String fileName, String text, Boolean method) throws IOException {
         
         //File sınıfı ve FileWriter, BufferedWriter Sınıfı Kullanılmıştır.
        fileName = fileName;
        text = text;
        method = method;
        file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }       
        fileWriter = new FileWriter(file, method);
        buffWriter = new BufferedWriter(fileWriter);
        buffWriter.write(text);
        buffWriter.close();
        System.out.println("\nDosyanız Başarılı Bir Şekilde Oluşturuldu ve Yazılma İşlemi Tamamlandır.");
    }
}
    class read{
        public read(String fileName) throws FileNotFoundException, IOException{
            //File Sınıfı ve FileReader, BufferedReader Sınıfı Kullanılmıştır.
            fileName = fileName;
            String line;
            file = new File(fileName);
            fileReader = new FileReader(file);
            buffReader = new BufferedReader(fileReader);
            while((line = buffReader.readLine()) != null){
                System.out.println(line.toString());
            }
        }
    }
    
    class copy{
        /*
            Kopyalama işleminde ise eğer kopyalanacağı dosya yok ise dosya yaratmak için File
            Diğer dosyayı kopyalamak için FileReader ve BufferedReader, içerisine yazmak için ise FileWriter ve BufferedWriter Kullanılmıştır.
        */
        public copy (String fileName, String copyFileName) throws FileNotFoundException, IOException{
            fileName = fileName;
            copyFileName = copyFileName;
            file = new File(copyFileName);
            if(!file.exists()){
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            buffWriter = new BufferedWriter(fileWriter);
            String line;
            file = new File(fileName);
            fileReader = new FileReader(file);
            buffReader = new BufferedReader(fileReader);
            while((line = buffReader.readLine()) != null){
                buffWriter.write(line+" \n");
            }
            buffWriter.close();
            System.out.print("\n** Dosya Kopyalama İşleminiz Başarıyla Tamamlanmıştır. **\n");
        }
    }
    
    // Getter ve Setter 
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getMethod() {
        return method;
    }

    public void setMethod(Boolean method) {
        this.method = method;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufffWriter() {
        return buffWriter;
    }

    public void setBufffWriter(BufferedWriter bufffWriter) {
        this.buffWriter = bufffWriter;
    }
}
