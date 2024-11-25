package edu.zafu.teaai.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 图床上传文件需要的常量
 *
 * @author ColaBlack
 */
@Component
public class ImageBedConstant {
    @Value("${image.bed.url}")
    public static String IMAGE_BED_URL;

    @Value("${image.bed.uploadUrl}")
    public static String IMAGE_BED_UPLOAD_URL;

    @Value("${image.bed.authCode}")
    public static String AUTH_CODE;
}
