package com.github.bingoohuang.springboottrial.util;


import com.google.common.io.Files;

import java.util.HashMap;
import java.util.Map;

public class MimeTypes {
    /**
     * Method getting particular Mime type for the extension (key)
     *
     * @param filename - file name with extension
     * @return String mine type
     */
    public static String getFileMimeType(String filename) {
        return getMimeType(Files.getFileExtension(filename));
    }

    /**
     * Method getting particular Mime type for the extension (key)
     *
     * @param fileExtension - file extension without dot
     * @return String mine type
     */
    public static String getMimeType(String fileExtension) {
        return mimeTypes.getOrDefault(fileExtension.toLowerCase(), "text/html");
    }

    // https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Complete_list_of_MIME_types
    // http://www.iana.org/assignments/media-types/media-types.xhtml
    private static Map<String, String> mimeTypes = new HashMap<String, String>() {{
        put("ai", "application/postscript");
        put("aif", "audio/x-aiff");
        put("aifc", "audio/x-aiff");
        put("aiff", "audio/x-aiff");
        put("asc", "text/plain");
        put("asf", "video/x.ms.asf");
        put("asx", "video/x.ms.asx");
        put("au", "audio/basic");
        put("avi", "video/x-msvideo");
        put("bcpio", "application/x-bcpio");
        put("bin", "application/octet-stream");
        put("cab", "application/x-cabinet");
        put("cdf", "application/x-netcdf");
        put("class", "application/java-vm");
        put("cpio", "application/x-cpio");
        put("cpt", "application/mac-compactpro");
        put("crt", "application/x-x509-ca-cert");
        put("csh", "application/x-csh");
        put("css", "text/css");
        put("csv", "text/comma-separated-values");
        put("dcr", "application/x-director");
        put("dir", "application/x-director");
        put("dll", "application/x-msdownload");
        put("dms", "application/octet-stream");
        put("doc", "application/msword");
        put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        put("dtd", "application/xml-dtd");
        put("dvi", "application/x-dvi");
        put("dxr", "application/x-director");
        put("eps", "application/postscript");
        put("etx", "text/x-setext");
        put("exe", "application/octet-stream");
        put("ez", "application/andrew-inset");
        put("gif", "image/gif");
        put("gtar", "application/x-gtar");
        put("gz", "application/gzip");
        put("gzip", "application/gzip");
        put("hdf", "application/x-hdf");
        put("htc", "text/x-component");
        put("hqx", "application/mac-binhex40");
        put("html", "text/html");
        put("htm", "text/html");
        put("ice", "x-conference/x-cooltalk");
        put("ief", "image/ief");
        put("iges", "model/iges");
        put("igs", "model/iges");
        put("jar", "application/java-archive");
        put("java", "text/plain");
        put("jnlp", "application/x-java-jnlp-file");
        put("jpeg", "image/jpeg");
        put("jpe", "image/jpeg");
        put("jpg", "image/jpeg");
        put("js", "application/x-javascript");
        put("jsp", "text/plain");
        put("kar", "audio/midi");
        put("latex", "application/x-latex");
        put("lha", "application/octet-stream");
        put("lzh", "application/octet-stream");
        put("man", "application/x-troff-man");
        put("mathml", "application/mathml+xml");
        put("me", "application/x-troff-me");
        put("mesh", "model/mesh");
        put("mid", "audio/midi");
        put("midi", "audio/midi");
        put("mif", "application/vnd.mif");
        put("mol", "chemical/x-mdl-molfile");
        put("movie", "video/x-sgi-movie");
        put("mov", "video/quicktime");
        put("mp2", "audio/mpeg");
        put("mp3", "audio/mpeg");
        put("mpeg", "video/mpeg");
        put("mpe", "video/mpeg");
        put("mpga", "audio/mpeg");
        put("mpg", "video/mpeg");
        put("ms", "application/x-troff-ms");
        put("msh", "model/mesh");
        put("msi", "application/octet-stream");
        put("nc", "application/x-netcdf");
        put("oda", "application/oda");
        put("ogg", "application/ogg");
        put("pbm", "image/x-portable-bitmap");
        put("pdb", "chemical/x-pdb");
        put("pdf", "application/pdf");
        put("pgm", "image/x-portable-graymap");
        put("pgn", "application/x-chess-pgn");
        put("png", "image/png");
        put("pnm", "image/x-portable-anymap");
        put("ppm", "image/x-portable-pixmap");
        put("ppt", "application/vnd.ms-powerpoint");
        put("ps", "application/postscript");
        put("qt", "video/quicktime");
        put("ra", "audio/x-pn-realaudio");
        put("ra", "audio/x-realaudio");
        put("ram", "audio/x-pn-realaudio");
        put("ras", "image/x-cmu-raster");
        put("rdf", "application/rdf+xml");
        put("rgb", "image/x-rgb");
        put("rm", "audio/x-pn-realaudio");
        put("roff", "application/x-troff");
        put("rpm", "application/x-rpm");
        put("rpm", "audio/x-pn-realaudio");
        put("rtf", "application/rtf");
        put("rtx", "text/richtext");
        put("ser", "application/java-serialized-object");
        put("sgml", "text/sgml");
        put("sgm", "text/sgml");
        put("sh", "application/x-sh");
        put("shar", "application/x-shar");
        put("silo", "model/mesh");
        put("sit", "application/x-stuffit");
        put("skd", "application/x-koan");
        put("skm", "application/x-koan");
        put("skp", "application/x-koan");
        put("skt", "application/x-koan");
        put("smi", "application/smil");
        put("smil", "application/smil");
        put("snd", "audio/basic");
        put("spl", "application/x-futuresplash");
        put("src", "application/x-wais-source");
        put("sv4cpio", "application/x-sv4cpio");
        put("sv4crc", "application/x-sv4crc");
        put("svg", "image/svg+xml");
        put("swf", "application/x-shockwave-flash");
        put("t", "application/x-troff");
        put("tar", "application/x-tar");
        put("tar.gz", "application/x-gtar");
        put("tcl", "application/x-tcl");
        put("tex", "application/x-tex");
        put("texi", "application/x-texinfo");
        put("texinfo", "application/x-texinfo");
        put("tgz", "application/x-gtar");
        put("tiff", "image/tiff");
        put("tif", "image/tiff");
        put("tr", "application/x-troff");
        put("tsv", "text/tab-separated-values");
        put("txt", "text/plain");
        put("ustar", "application/x-ustar");
        put("vcd", "application/x-cdlink");
        put("vrml", "model/vrml");
        put("vxml", "application/voicexml+xml");
        put("wav", "audio/x-wav");
        put("wbmp", "image/vnd.wap.wbmp");
        put("wmlc", "application/vnd.wap.wmlc");
        put("wmlsc", "application/vnd.wap.wmlscriptc");
        put("wmls", "text/vnd.wap.wmlscript");
        put("wml", "text/vnd.wap.wml");
        put("wrl", "model/vrml");
        put("wtls-ca-certificate", "application/vnd.wap.wtls-ca-certificate");
        put("xbm", "image/x-xbitmap");
        put("xht", "application/xhtml+xml");
        put("xhtml", "application/xhtml+xml");
        put("xls", "application/vnd.ms-excel");
        put("xml", "application/xml");
        put("xpm", "image/x-xpixmap");
        put("xsl", "application/xml");
        put("xslt", "application/xslt+xml");
        put("xul", "application/vnd.mozilla.xul+xml");
        put("xwd", "image/x-xwindowdump");
        put("xyz", "chemical/x-xyz");
        put("z", "application/compress");
        put("zip", "application/zip");
    }};


}