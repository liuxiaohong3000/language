package com.language.word.model.vo;

import com.language.word.model.BWord;
import com.language.word.model.BWordTab;

/**
 * Created by Administrator on 2017/6/6.
 */
public class WordVO {
    private BWord word;
    private BWordTab tab;

    public BWord getWord() {
        return word;
    }

    public void setWord(BWord word) {
        this.word = word;
    }

    public BWordTab getTab() {
        return tab;
    }

    public void setTab(BWordTab tab) {
        this.tab = tab;
    }
}
