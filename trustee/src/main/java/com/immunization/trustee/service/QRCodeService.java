package com.immunization.trustee.service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@Service
public class QRCodeService {

    public String getBase64(String certificateURI) throws Exception {

        int imageSize = 150;
        BitMatrix matrix = new MultiFormatWriter().encode(certificateURI, BarcodeFormat.QR_CODE, imageSize, imageSize);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", bos);
        String image = Base64.getEncoder().encodeToString(bos.toByteArray());
        return image;
    }
}
