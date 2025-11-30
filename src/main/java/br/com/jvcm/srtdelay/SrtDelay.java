package br.com.jvcm.srtdelay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import br.com.jvcm.srtdelay.srtparser.SubtitleListener;
import br.com.jvcm.srtdelay.srtparser.srtLexer;
import br.com.jvcm.srtdelay.srtparser.srtParser;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
    name = "srtdelay", 
    version = "1.0.0", 
    mixinStandardHelpOptions = true, 
    sortOptions=false, 
    sortSynopsis = false
)
public class SrtDelay implements Runnable {

    @Option(names = {"-ss"}, description= "Tempo de início")
    String startTimeString = "00:00:00,000";

    @Option(names = {"-e"}, description= "Tempo de fim")
    String endTimeString = "99:99:99,999";
    
    @Option(names = {"-d"}, description= "Delay aplicado em ms")
    int delayTime = 0;

    @Parameters(paramLabel = "<input>", description= "Arquivo de entrada")
    File inputFile;

    @Parameters(paramLabel = "<output>", description= "Arquivo de saída")
    File outputFile;


    /**
     * @param df Data final
     * @param di Data inicial
     * @return Diferença em ms das datas
     */
    long getTimeDelta(Date df, Date di){
        return (df.getTime() - di.getTime());
    }

    /**
     * @param file Objeto com o arquivo
     * @return o conteúdo
     */
    String readFile(File file){
        FileReader fr;
        
        try{
            fr = new FileReader(file);
        }catch(FileNotFoundException e){
            throw new Error("Arquivo não encontrado");
        }

        BufferedReader br = new BufferedReader(fr);
        StringBuilder ans = new StringBuilder();
        String line;
        
        try{
            while((line = br.readLine()) != null){
                ans.append(line);
                ans.append(System.lineSeparator());
            }
        }catch(IOException e){
            throw new Error("Erro IO");
        }
        
        return ans.toString();
    }
    
    /**
     * @param content String dos dados no arquivo
     * @return a arvore parseada
     */
    String updateSrt(String content){
        CharStream input = CharStreams.fromString(content);
        srtLexer lexer = new srtLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParseTree parsedTree =  new srtParser(tokens).file_();

        ParseTreeWalker walker = new ParseTreeWalker();
        SubtitleListener listener = new SubtitleListener(tokens);
        walker.walk(listener, parsedTree);

        return listener.getUpdated();
        
    }
    

    @Override
    public void run()  {

        // File outputFile = new File(outputFilePath);

        DelayUtils.setDelayTime(delayTime);
        DelayUtils.startTimeString = startTimeString;
        DelayUtils.endTimeString = endTimeString;

        
        String updated = updateSrt(readFile(inputFile));

        try(PrintWriter out = new PrintWriter(outputFile)){
            out.print(updated);
        }catch (IOException e) {
            throw new Error("Erro de I/O");
        }

    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new SrtDelay()).execute(args);
        System.exit(exitCode);
        
    }

}
