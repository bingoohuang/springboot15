package com.github.bingoohuang.springboottrial.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import lombok.Data;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class JSONSchema {
  @Data
  public static class Bean {
    private String key;
    private String value;
  }

  public static class UnknownKeyException extends RuntimeException {
    public UnknownKeyException(String unknownKey) {
      super("unknown key " + unknownKey);
    }
  }

  public static void main(String[] args) {
    ExtraProcessor processor =
        (object, key, value) -> {
          throw new UnknownKeyException(key);
        };

    String s = "[{`key`:`谢谢`, `key2`:`invalid`}]".replace('`', '"');

    if (s.startsWith("{")) {
      val bean = JSON.parseObject(s, Bean.class, processor);
      System.out.println(bean);
    } else if (s.startsWith("[")) {
      val beans = parseArray(s, Bean.class, processor);
      System.out.println(beans);
    }
  }

  public static <T> List<T> parseArray(String text, Class<T> clazz, ExtraProcessor extraProcessor) {
    if (text == null) {
      return null;
    }

    try (val parser = new DefaultJSONParser(text, ParserConfig.getGlobalInstance())) {
      if (extraProcessor != null) {
        parser.getExtraProcessors().add(extraProcessor);
      }

      JSONLexer lexer = parser.lexer;
      int token = lexer.token();
      if (token == JSONToken.NULL) {
        lexer.nextToken();
        return null;
      } else if (token == JSONToken.EOF && lexer.isBlankInput()) {
        return null;
      } else {
        List<T> list = new ArrayList<>();
        parser.parseArray(clazz, list);
        parser.handleResovleTask(list);
        return list;
      }
    }
  }
}
