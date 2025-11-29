package br.com.jvcm.srtdelay.srtparser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import br.com.jvcm.srtdelay.Subtitle;
import br.com.jvcm.srtdelay.srtparser.srtParser.SubtitleContext;

public class SubtitleListener extends srtBaseListener{
    public static List<Subtitle> subtitles;
    TokenStreamRewriter rewriter;

    public SubtitleListener(CommonTokenStream tokens) {
        this.rewriter = new TokenStreamRewriter(tokens);
        if(subtitles==null){
            subtitles = new ArrayList<>();
        }
    }

    @Override
    public void enterSubtitle(SubtitleContext ctx) {
        String[] tempos = ctx.TIMESTAMP().toString().split(" --> ");
        Subtitle sub = new Subtitle();
        sub.number = Integer.parseInt(ctx.NUMBER().getText());
        sub.tokenIndex = ctx.TIMESTAMP().getSymbol().getTokenIndex();
        sub.setTimestamp(tempos[0], tempos[1]);
        subtitles.add(sub);
        super.enterSubtitle(ctx);
    }
    
    @Override
    public void exitSubtitle(SubtitleContext ctx) {
        int tokenIndex = ctx.TIMESTAMP().getSymbol().getTokenIndex();
        Subtitle currentSubtitle = subtitles.stream()
                .filter(sub -> sub.tokenIndex == tokenIndex)
                .findFirst()
                .orElse(null);
        if(currentSubtitle!=null){
            rewriter.replace(tokenIndex, currentSubtitle.getTimestamp());
        }
        super.exitSubtitle(ctx);
    }

    public String getUpdated(){
        return rewriter.getText();
    }
}
