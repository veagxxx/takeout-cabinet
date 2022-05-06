package com.zhy.takeoutcabinet.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码工具类
 */
public class VerificationCode {
    private int width = 80; // 验证码宽度
    private int height = 34; // 验证码高度
    private Color bgColor = new Color(255, 255, 255);
    private String[] fontNames = {"宋体", "楷体", "隶书", "微软雅黑"};
    private Random random = new Random();
    private String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ"; // 验证码字符
    private String captcha; // 验证码

    /**
     * 生成随机颜色
     * @return color
     */
    private Color randomColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 生成随即字体
     * @return 字体
     */
    private Font randomFont() {
        String fontName = fontNames[random.nextInt(fontNames.length)];
        int size = random.nextInt(5) + 24;
        return new Font(fontName, Font.BOLD, size);
    }

    /**
     * 获取单个随机字符
     * @return 随机字符
     */
    private char randomChar() {
        return codes.charAt(random.nextInt(codes.length()));
    }

    /**
     * 生成空白验证码图片
     * @return image
     */
    private BufferedImage creatImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(bgColor);
        graphics.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 获取验证码图片
     * @return image
     */
    public BufferedImage getImage() {
        BufferedImage image = creatImage();
        Graphics graphics = image.getGraphics();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String code = randomChar() + "";
            // 添加一个字符
            stringBuffer.append(code);
            graphics.setColor(randomColor());
            graphics.setFont(randomFont());
            int x = i * width / 4;
            graphics.drawString(code, x, height - 8);
        }
        // 画干扰线
        drawLine(image);
        // 保存验证码
        captcha = stringBuffer.toString();
        return image;
    }

    /**
     * 画干扰线
     * @param image image
     */
    private void drawLine(BufferedImage image) {
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        for (int i = 0; i < 5; i++) {
            int startX = random.nextInt(width);
            int endX = random.nextInt(width);
            int startY = random.nextInt(height);
            int endY = random.nextInt(height);
            // 设置线颜色
            graphics2D.setColor(randomColor());
            // 描边
            graphics2D.setStroke(new BasicStroke(1.5f));
            // 画线
            graphics2D.drawLine(startX, startY, endX, endY);
        }
    }

    /**
     * 获取验证码
     * @return captcha
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * 输出验证码图片
     * @param image image
     * @param outputStream 输出流
     * @throws IOException 异常
     */
    public static void outputImage(BufferedImage image, OutputStream outputStream) throws IOException {
        ImageIO.write(image, "JPEG", outputStream);
    }
}
