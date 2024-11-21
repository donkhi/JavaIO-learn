## 基本的文件(文件夹)操作
### 创建文件夹

使用File类 File file = new File("路径");

常用的File方法：
-[ ] `file.createNewFile()`:创建一个空文件，在文件操作中无论知不知道文件存在都要先创建。
-[ ] `file.mkdirs()`:创建目录或多级目录，父目录不存在也会创建。
-[ ] `file.delete()`:返回一个boolean。
- [ ] `文件路径`
- `file.getpath()`相对路径
- `file.getAbsolutePath()`返回绝对路径　
-[ ] `列出目录文件`
- `list()` 返回目录中的文件名数组
- `listFiles()` 返回目录的File对象数组
- 区别在于一个是String[] 另一个是File[]


### 删除文件夹
采用递归
如果目标文件是一个目录,那么列出此目录的子目录，
如果此目录不是空的递归执行这个方法，终止条件是删除此文件。