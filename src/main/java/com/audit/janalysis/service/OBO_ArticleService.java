package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Article;
import com.audit.janalysis.mapper.OBO_ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OBO_ArticleService  {
        @Autowired
        private OBO_ArticleMapper oboArticleMapper;

        public int insert(OBO_Article oboArticle) {
            // 插入文章
            return oboArticleMapper.insert(oboArticle);
        }

        public int delete(OBO_Article oboArticle) {
            // 删除文章
            return oboArticleMapper.deleteById(oboArticle);
        }

        public int update(OBO_Article oboArticle) {
            // 更新文章
            return oboArticleMapper.updateById(oboArticle);
        }

        public OBO_Article getArticleById(int articleId) {
            return oboArticleMapper.selectById(articleId);
        }

        public List<OBO_Article> getAllArticles() {
            return oboArticleMapper.selectList(null);
        }


}
