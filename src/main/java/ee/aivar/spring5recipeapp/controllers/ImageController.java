package ee.aivar.spring5recipeapp.controllers;

import ee.aivar.spring5recipeapp.command.RecipeCommand;
import ee.aivar.spring5recipeapp.service.ImageService;
import ee.aivar.spring5recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{recipeId}/image")
    public String showUploadForm(@PathVariable String recipeId, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/imageuploadform";
    }

    @PostMapping("recipe/{recipeId}/image")
    public String handleImagePost(@PathVariable String recipeId, @RequestParam("imagefile") MultipartFile file) {

        imageService.saveImageFile(Long.valueOf(recipeId), file);

        return "redirect:/recipe/" + recipeId + "/show";
    }

    @GetMapping("recipe/{recipeId}/recipeimage")
    public void renderImage(@PathVariable String recipeId, HttpServletResponse response) throws IOException {

        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));

        if (recipeCommand.getImage() != null) {
            byte[] bytes = new byte[recipeCommand.getImage().length];

            int i = 0;

            for (Byte b : recipeCommand.getImage()) {
                bytes[i++] = b;
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(bytes);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
