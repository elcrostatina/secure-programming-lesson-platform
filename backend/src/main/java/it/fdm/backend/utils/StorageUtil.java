package it.fdm.backend.utils;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import sun.nio.ch.IOUtil;

public class StorageUtil {
     final static AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();

    public static StreamingResponseBody getObject(String bucketName, String objectKey) {
        S3ObjectInputStream file = s3.getObject(bucketName, objectKey).getObjectContent();

        return outputStream -> {
            int numberOfBytesToWrite = 0;
            byte[] data = new byte[1024];
            while ((numberOfBytesToWrite = file.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, numberOfBytesToWrite);
            }
            file.close();
        };
    }
}
