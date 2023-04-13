package pojos;

public class JasonPlaceHolderREQUESTBody_Pojo {

    //1-tum key degerleri class levelde aldıklari data turlarne gore private variable olalrak olusturalim


    private String title;
    private String body;
    private int userId;
    private int id;
    //2- tum variable lar icin getter setter lari olusturalim.


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    //3-tum variable lari iceren parametreli bir constructor olusturuyoruz.


    public JasonPlaceHolderREQUESTBody_Pojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
    //4-parametreli konstructor olusturdugumuz icin parametresiz bir constructor olusturuyoruz.

    public JasonPlaceHolderREQUESTBody_Pojo() {
    }

    //5-to strign metodunu olusturuyoruz.

    @Override
    public String toString() {
        return "JasonPlaceHolderREQUESTBody_Pojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
