## out对应的是Write写入字节
## in对应的是Reader读出字节
### **`FileInputStream` 和 `FileReader` 的区别**

`FileInputStream` 和 `FileReader` 都是 Java 中用于读取文件内容的类，但它们有不同的使用场景和特点。以下是两者的详细比较：

---

### **1. 主要区别**

| 特性                 | **FileInputStream**                                           | **FileReader**                                              |
|----------------------|-------------------------------------------------------------|------------------------------------------------------------|
| **继承体系**         | 属于字节流，继承自 `InputStream`                              | 属于字符流，继承自 `Reader`                                  |
| **读取单位**         | 按 **字节（byte）** 读取                                      | 按 **字符（char）** 读取                                    |
| **适用文件类型**     | 可处理所有文件类型（如文本文件、图片、音频等二进制文件）        | 专门处理文本文件                                            |
| **编码处理**         | 不会处理编码，读取的是原始字节                                 | 会处理字符编码，适合读取和解析文本内容                       |
| **用法场景**         | 适合读取二进制文件（如图片、视频、音频等）                    | 适合读取纯文本文件（如 `.txt` 文件）                         |

---

### **2. 使用场景**

#### **FileInputStream**
- 用于读取任何类型的文件，包括文本文件和二进制文件（如图片、音频等）。
- 读取的数据是 **原始字节流**，需要手动将字节转换为字符（如果读取文本文件）。

**示例：读取字节数据**
```java
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            int content;
            while ((content = fis.read()) != -1) {
                // 将字节转换为字符并打印
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### **FileReader**
- 专门用于读取 **文本文件**，以 **字符流** 的形式读取内容。
- 自动处理字符编码，适合处理纯文本文件中的字符。

**示例：读取字符数据**
```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("example.txt")) {
            int content;
            while ((content = fr.read()) != -1) {
                // 直接打印字符
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### **3. 继承关系**

#### **FileInputStream**
- **继承体系**：
    - `java.lang.Object`
    - `java.io.InputStream`
    - `java.io.FileInputStream`
- **适用于字节流的操作**，可以处理任何文件类型。

#### **FileReader**
- **继承体系**：
    - `java.lang.Object`
    - `java.io.Reader`
    - `java.io.FileReader`
- **适用于字符流的操作**，专门为文本文件设计。

---

### **4. 注意事项**

1. **FileInputStream 的编码处理**：
    - 读取文本文件时需要手动处理字符编码，可以结合 `InputStreamReader` 使用。
    - 示例：
      ```java
      import java.io.*;
 
      public class InputStreamReaderExample {
          public static void main(String[] args) {
              try (InputStreamReader isr = new InputStreamReader(new FileInputStream("example.txt"), "UTF-8")) {
                  int content;
                  while ((content = isr.read()) != -1) {
                      System.out.print((char) content);
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      ```

2. **FileReader 的局限性**：
    - 不支持处理二进制文件，因为它只处理字符。
    - 默认使用平台的字符编码（如 UTF-8 或 GBK），如果文件的编码不同，可能会导致乱码。

---

### **5. 总结**

| **类别**         | **FileInputStream**                         | **FileReader**                              |
|------------------|--------------------------------------------|--------------------------------------------|
| **数据类型**     | 字节流，用于处理字节数据                     | 字符流，用于处理文本数据                    |
| **适用场景**     | 读取二进制文件（如图片、音频、视频等）        | 读取文本文件（如 `.txt` 文件）               |
| **编码处理**     | 需要手动处理字符编码                         | 自动处理字符编码，适合文本内容               |
| **推荐用途**     | 处理二进制文件或手动解析文本                  | 直接读取文本内容，效率更高                  |

根据实际需求选择适合的类：
- 如果要读取二进制文件或需要精确控制字节流，请选择 **FileInputStream**。
- 如果要读取纯文本文件，请选择 **FileReader**，更加简洁高效。