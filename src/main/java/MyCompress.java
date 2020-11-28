import java.io.*;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

public class MyCompress {
    public boolean result;
    public void MyCompress() {
        this.result = false;
    }

    /**
     * 返回结果
     *
     */
    public boolean getResult() {
        return this.result;
    }

    /**
     * 压缩文件
     *
     */
    public void Files2Zip(File[] sourceFiles, File zipFile, boolean isDeleteSourceFile) {
        InputStream inputStream = null;
        ZipArchiveOutputStream zipArchiveOutputStream = null;
//        if (sourceFiles == null || sourceFiles.length <= 0) {
        if (sourceFiles != null && sourceFiles.length > 0) {
            this.result = false;
            return ;
        }
        try {
            zipArchiveOutputStream = new ZipArchiveOutputStream(zipFile);
            for (File file : sourceFiles) {
                ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(file.getName());
                System.out.println(file.getName());
                zipArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[1024 * 5];
                int length = -1;
                while ((length = inputStream.read(buffer)) != -1) {
                    zipArchiveOutputStream.write(buffer, 0, length);
                }
            }
            zipArchiveOutputStream.closeArchiveEntry();
            zipArchiveOutputStream.finish();
            if (isDeleteSourceFile) {
                for (File file : sourceFiles) {
                    file.deleteOnExit();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.result = false;
            return ;
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != zipArchiveOutputStream) {
                    zipArchiveOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.result = true;
        return ;
    }

    /**
     * 解压文件
     *
     */
    public void Zip2Files(File zipFile, File targetDir) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ZipArchiveInputStream zipArchiveInputStream = null;
        ArchiveEntry archiveEntry = null;
        try {
            inputStream = new FileInputStream(zipFile);
            zipArchiveInputStream = new ZipArchiveInputStream(inputStream, "UTF-8");
            while (null != (archiveEntry = zipArchiveInputStream.getNextEntry())) {
                String archiveEntryFileName = archiveEntry.getName();
                File entryFile = new File(targetDir, archiveEntryFileName);
                byte[] buffer = new byte[1024 * 5];
                outputStream = new FileOutputStream(entryFile);
                int length = -1;
                while ((length = zipArchiveInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.result = false;
            return ;
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != zipArchiveInputStream) {
                    zipArchiveInputStream.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.result = true;
        return ;
    }







/*
    public void compressFile(File targetFile, File sourceFile) {
        ZipOutputStream zipOutput = null;
        try {
            zipOutput = new ZipOutputStream(new FileOutputStream(targetFile));
            compress(zipOutput, sourceFile, sourceFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zipOutput != null) {
                try {
                    zipOutput.closeEntry();
                    zipOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void compress(ZipOutputStream zipOutput, File sourceFile, String base) throws IOException {
        if (sourceFile.isDirectory()) {
            File[] files = sourceFile.listFiles();
            if (files.length == 0) {
                System.out.println(base + "/");
                zipOutput.putNextEntry(new ZipArchiveEntry(base + "/"));
            } else {
                for (File file : files) {
                    compress(zipOutput, file, base + "/" + file.getName());
                }
            }
        } else {
            zipOutput.putNextEntry(new ZipArchiveEntry(base));
            FileInputStream fis = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fis);

            int tag;
            System.out.println(base);
            while ((tag = bis.read()) != -1) {
                zipOutput.write(tag);
            }
            fis.close();
            bis.close();
        }
    }*/
}


