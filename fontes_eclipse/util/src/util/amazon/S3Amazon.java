package util.amazon;

import java.io.File;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

public class S3Amazon {

    private AmazonS3 s3client;
    private String bucket;

    public AmazonS3 getS3client() {
        return s3client;
    }

    public void setS3client(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public S3Amazon() {
    }

    public S3Amazon(String bucket) {
        try {
            this.s3client = new AmazonS3Client(new ProfileCredentialsProvider());
            this.bucket = bucket;
        } catch (AmazonServiceException ase) {
            ase.printStackTrace(System.err);
        } catch (AmazonClientException ace) {
            ace.printStackTrace(System.err);
        }
    }

    public boolean carregarImagem(String diretorio, File arquivo) {
        boolean carregou = false;
        try { 
            s3client.putObject(new PutObjectRequest(bucket, diretorio + "/" + arquivo.getName(), arquivo)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            carregou = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carregou;
    }
    
    public boolean apagarImagem(String diretorio, File arquivo) {
        boolean apagou = false;
        try { 
            s3client.deleteObject(new DeleteObjectRequest(bucket, diretorio + "/" + arquivo.getName()));
            apagou = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apagou;
    }

}
