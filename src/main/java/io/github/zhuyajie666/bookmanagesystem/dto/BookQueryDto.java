package io.github.zhuyajie666.bookmanagesystem.dto;

public class BookQueryDto extends PageQueryDto {

    private String keyword;

    public String getKeyword(){
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
