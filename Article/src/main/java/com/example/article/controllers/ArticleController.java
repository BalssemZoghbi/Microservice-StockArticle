package com.example.Article.controllers;




import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {


    @Autowired
    IArticleService iArticleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArticleDto> AllArticles() {
        return iArticleService.AllArticles();
    }

    @GetMapping("/{id}")
    public ArticleDto getArticleById(@PathVariable("id") Long id) {return iArticleService.getArticleById(id);}

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDto addArticle(@RequestBody ArticleDto ArticleDto) {return iArticleService.saveArticle(ArticleDto);}

    @PutMapping("/{id}")
    public ArticleDto updateArticle(@PathVariable Long id, @RequestBody ArticleDto ArticleDto) {return iArticleService.updateArticle(
            ArticleDto);}
    @GetMapping("/display/{idArticle}")
    Article retrieveArticle(@PathVariable("idArticle") long idArticle) {
        return iArticleService.getArticle(idArticle);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        iArticleService.deleteArticleById(id);
    }


}
