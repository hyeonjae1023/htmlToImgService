package org.example;

public class NaverAutomation {

    // 서버 주소: https://html2img.com
    // 서버 주소: http://localhost

    // @GetMapping("/api/capture")
    public static void main(String[] args) {

            String sourceUrl = "https://www.naver.com";
            Integer width = 500;
            Integer height = 500;
            Integer x = 100;
            Integer y = 100;

            CaptureRequest request = new CaptureRequest(sourceUrl, width, height, x, y);


            String pngFileName = CaptureService.capture(request);

        // model.addAttributes("fileName", pngFilename);
        // retrun "redirect:/dfdhfif"

    }
}
