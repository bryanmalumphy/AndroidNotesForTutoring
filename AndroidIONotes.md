# Recycler View and Fragment Project

## Java I/O
The session with the student indicated that the professor linked out to the File API
in order to read from the text files for each Quiz to be integrated into the App.

This involved:
 ```Java
context.getFilesDir()
 ```

 Which calls the file directory for Internal Storage. The problem is, it's impossible to read files
 from this directory without first writing the files to this location during runtime. This is not
 the way that is intended to store a resource like a text file. Likely there was a communication
 error on the part of the professor that hinted this was the way the student was supposed to read
 from the given data files.

 Instead, the way the book proposes to handle this file (Chapter 6 page 175) is to store this as
 a raw resource file. This is done by going to the "res" folder in android studio, creating a 
 Resource File Directory named "raw" and adding the text file to this folder, and renaming it to 
 "quizone.txt"

 You can then reference this resource file with:
 ```Java
InputStream is = this.getResources().openRawResource(R.raw.quizone);
 ```

 With this input stream, we can retrieve the individual lines of data with a StringBuilder as follows:
```Java
String readInput = "";
StringBuilder stringBuilder = new StringBuilder();
InputStream is = this.getResources().openRawResource(R.raw.quizone);
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
while (true) {
    try {
        if ((readInput = reader.readLine()) == null) break;
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    stringBuilder.append(readInput).append("\n");
    Log.i("FILE LINE:", readInput);
}
```
This will print each of the lines in the file to the console from the variable "string"

The "Log.i()" function here is Androids console mechanic that lets us tag things we need to keep track of.
From here, we can take these lines in the order that they come in to parse into a Quiz/Question Object, which is constructed
as follows:

```Java
class Question {
    private String question;
    private ArrayList<String> answers;
    private int correctAnswerIndex;
}

class Quiz {
    private String title;
    private ArrayList<Questions> questions;
}
```

The first line in the file will be the title, which we can store as the title. We can then iterate over the
lines from the file, taking the second, seventh, and so on to be a question title, and third-sixth, and eighth-eleventh
and so on as the answers. Making sure to note the correct answer by checking for the star character in the list, and
then storing that index in the answers array as the correctAnswerIndex.

With an Array of quizes to use, we can then create our Adapter for our RecyclerView, in a later part of the project.