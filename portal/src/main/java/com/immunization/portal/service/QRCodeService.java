package com.immunization.portal.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class QRCodeService {

    public String getBase64(String confirmationURI) throws Exception {
        int imageSize = 150;
        BitMatrix matrix = new MultiFormatWriter().encode(confirmationURI, BarcodeFormat.QR_CODE, imageSize, imageSize);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", bos);
        return Base64.getEncoder().encodeToString(bos.toByteArray());
    }
}
