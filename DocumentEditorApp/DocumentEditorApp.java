package SystemDesign.DocumentEditorApp;
import java.util.*;
import java.io.*;

interface DocumentElement{
    public abstract String render();
}

interface Persistence{
    void save(String data);
}

class TextElement implements DocumentElement{
    private String text;
    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return text;
    }
}

class ImageElement implements DocumentElement{
    private String imagePath;
    public ImageElement(String imagePath){
        this.imagePath = imagePath;
    }
    @Override
    public String render(){
        return "[Image: " + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement{
    @Override
    public String render(){
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement{
    @Override
    public String render(){
        return "\t";
    }
}

class Document{
    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element){
        documentElements.add(element);
    }

    public String render(){
        StringBuilder result = new StringBuilder();
        for(DocumentElement element: documentElements){
            result.append(element.render());
        }
        return result.toString();
    }
}

class FileStorage implements Persistence{
    @Override
    public void save(String data){
        try{
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt ");
        }
        catch(IOException e){
            System.out.println("Error: Unable to open file for writing");
        }
    }
}

class DBStorage implements Persistence{
    @Override
    public void save(String data){
        // Save to DB
    }
}

class DocumentEditor{
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage){
        this.document =document;
        this.storage = storage;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath){
        document.addElement(new ImageElement(imagePath));
    }

    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public void addTabSpace(){
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument(){
        storage.save(renderDocument());
    }
}

class Client{
    void doYourWork(){
        Document document = new Document();
        Persistence persistence = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}

public class DocumentEditorApp{
    public static void main(String[] args) {
        Client client = new Client();
        client.doYourWork();
    }
}

