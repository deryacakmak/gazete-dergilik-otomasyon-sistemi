package com.gazete_dergi_otomasyon.service;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import java.io.IOException;

public interface IFileOperationService {

     void uploadFile(UploadedFile uploadedFile, String issueNum) throws IOException;

}
