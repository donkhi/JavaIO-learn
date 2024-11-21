### **`read()` 和 `write()` 方法的比较**

在 Java 中，`read()` 和 `write()` 是用于文件操作的两种核心方法，分别用于 **读取** 和 **写入** 数据。它们在字节流和字符流中均有对应的方法。

以下是两者的详细比较：

---

### **1. 功能**

| 方法         | 功能                                               |
|--------------|----------------------------------------------------|
| **`read()`** | 从输入流中读取数据。                               |
| **`write()`** | 向输出流中写入数据。                              |

---

### **2. 使用场景**

| 方法         | 使用场景                                      |
|--------------|-----------------------------------------------|
| **`read()`** | 读取文件、网络流或其他输入流的数据。           |
| **`write()`** | 将数据写入文件、网络流或其他输出流。          |

---

### **3. 继承体系**

- **`read()`**：
    - 定义在 **输入流类** 中，如 `InputStream` 和 `Reader`。
    - 字节流类（如 `FileInputStream`）和字符流类（如 `FileReader`）都实现了 `read()` 方法。

- **`write()`**：
    - 定义在 **输出流类** 中，如 `OutputStream` 和 `Writer`。
    - 字节流类（如 `FileOutputStream`）和字符流类（如 `FileWriter`）都实现了 `write()` 方法。

---

### **4. 方法重载**

#### **`read()` 的常用形式**
1. **`int read()`**：
    - 读取单个字节或字符，返回其整数值。如果到达流的末尾，则返回 `-1`。
2. **`int read(byte[] b)` / `int read(char[] cbuf)`**：
    - 读取多个字节或字符，存储到指定数组中。
    - 返回实际读取的字节/字符数；到达末尾时返回 `-1`。
3. **`int read(byte[] b, int off, int len)` / `int read(char[] cbuf, int off, int len)`**：
    - 从流中读取数据，存储到数组的指定偏移量 `off` 开始的 `len` 个字节/字符中。

#### **`write()` 的常用形式**
1. **`void write(int b)`**：
    - 写入单个字节或字符。
2. **`void write(byte[] b)` / `void write(char[] cbuf)`**：
    - 将数组中所有字节或字符写入流。
3. **`void write(byte[] b, int off, int len)` / `void write(char[] cbuf, int off, int len)`**：
    - 从数组的偏移量 `off` 开始写入 `len` 个字节或字符到流中。

---

### **5. 性能和效率**

- **`read()`**：
    - 单个字符的读取效率较低，适合小型文件或逐字节操作。
    - 批量读取（如 `read(byte[] b)`）效率更高，适合处理大文件。

- **`write()`**：
    - 单个字符写入效率较低，适合小型数据。
    - 批量写入（如 `write(byte[] b)`）效率更高，适合处理大数据。

---

### **6. 示例代码**

#### **`read()` 示例**
```java
import java.io.FileReader;
import java.io.IOException;

public class ReadExample {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("example.txt")) {
            int character;
            while ((character = reader.read()) != -1) { // 逐字符读取
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### **`write()` 示例**
```java
import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write("Hello, World!"); // 写入字符串
            writer.write("\nThis is a test."); // 写入新行
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### **7. 总结比较**

| **特性**        | **`read()`**                                  | **`write()`**                               |
|-----------------|-----------------------------------------------|--------------------------------------------|
| **功能**        | 从输入流中读取数据。                          | 向输出流中写入数据。                        |
| **读取/写入单位**| 逐字节或逐字符读取，支持批量读取。             | 逐字节或逐字符写入，支持批量写入。          |
| **常用形式**    | `read()`, `read(byte[] b)`                   | `write()`, `write(byte[] b)`               |
| **性能**        | 单个读取性能较低，批量读取性能较高。            | 单个写入性能较低，批量写入性能较高。         |
| **适用场景**    | 读取文件、网络流、输入设备等。                 | 写入文件、网络流、输出设备等。              |

两者相辅相成，`read()` 用于从数据源中读取数据，而 `write()` 用于将数据保存或传输到目标。根据具体需求选择合适的用法和重载形式。