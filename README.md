# srt-delay

Atrasa legendas

## Instalação

```
mvn package
```

Vai gerar o arquivo `target/srtdelay-shaded.jar`

## Utilização

Criar um atalho

### Fish
```lua
function srtdelay
    java -jar target/srtdelay-shaded.jar $argv 
end
```
### Empacotar
>! Deu trabalho e não funciona fora da pasta que foi compilado o "binário"

| É preciso ter o graalJVM instalado

```sh
native-image \
    --no-fallback \
    -jar \
    --initialize-at-build-time=org.antlr.v4 \
    --allow-incomplete-classpath \
    -H:Name=srtdelay \
    -H:IncludeResources=".*"
    target/srtdelay-shaded.jar \
```


```plaintext
Usage:

srtdelay [-hV] [-ss=<startTimeString>] [-e=<endTimeString>]
                [-d=<delayTime>] <input> <output>
      <input>           Arquivo de entrada
      <output>          Arquivo de saída
  -ss=<startTime> Tempo de início
  -e=<endTime>    Tempo de fim
  -d=<delayTime>        Delay aplicado em ms
  -h, --help            Show this help message and exit.
  -V, --version         Print version information and exit.
```
