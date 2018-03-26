package tin.geebook.base;

import android.text.TextUtils;

import tin.geebook.constant.DownloadStateEnum;


/**
 * 类名：.java<br>
 * 描述： <br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2016-08-05<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */

public class BookBean {

    private Integer bId;//769,

    private Integer bookId;//769,

    private int libbookId;//2803107藏书馆图书ID',

    private String bookNo="";//;//null,

    private String yyName="";//资治通鉴全译本,

    private Integer yyPublisherId;//出版社id，

    private Integer num;//图书数量（大于0表示有文件夹，为空或等于0表示没有文件夹，

    private String yyCoverPath="";//group1/M00/00/B5/CgoBCFMpWi6AGhhFAAAJc3wq530261.jpg,

    private String yyIndexPath="";//索引路径，

    private String terminalSn="";//

    private String yyFileSize="";//文件大小

    private long timeout;//借阅到期时间  租/借有效期至,

    private String content="";//内容

    private String yyFilePath="";//文件路径

    private String  yyAuthor="";//作者 司马光等,

    private Integer downStatus;//下载状态1.下载成功，0下载失败

    private Integer resStatus;//0借阅状态   (0可借阅，-1表示用户没有该图书  1:已借出  2：已漂流)

    private String yyPublisherName="";//出版社名称

    private Integer lendNum=0;//借阅本数，

    private Integer lendsDay=0;//还有多少天过期，-1表示不是借阅的书，

    private Integer accountId;//用户id， '账号ID',

    private Integer holdStatus=0;//持有状态，0免费、1购买、2借阅、3－赠送、4上传、5试读,

    private long createTime;//":20170119145049,创建时间即上传时间

    private double readProgress = 0;//":0,阅读进度

    private String fileFormat;//":"EPUB",文件格式

    private int bookType;//":'图书类型(1－公版书，2－上传，3 数字图书,4-书城)',

    private Integer status=2;//"1－私藏，2－公开，0－其他(已借出，已漂流

//    添加的额外的功能性参数
    private String savePath="";//功能参数，用来保存本地下载保存路径

    private long lastReadTime=0;//功能参数，用来保存最后读取时间

    private Integer uploadStep;//上传步骤

    private Integer uploadId;//上传id

    private long partInd=0;//: 段索引

    private long readingLocation=0;//: 段索引

    private long chapterId=0;//章节id

    private long characterInd=0;//字符下标

    private long elementInd=0;//元素

    private boolean isFirstOpen=true;

    private String pubTotal="";//发行总数  1000本/第15个拷贝

    private String pubNo="";//发行班次：2016年8月 第1次发行

    private double totalWord=0.0;//总字数

    private String isbn="";

    private String sysSeriesId;//图书系列详情id


    //特例参数，图书详情里面创建图书详情返回的书本借阅情况
    private int isApply;
    //特例参数，图书详情里面创建图书详情返回的书本借阅情况
    private Integer mylibbookId;
    //特例参数，图书详情里面创建图书详情返回的书本借阅情况
    private String coverPath="";
    //特例参数，图书详情里面星级评定
    private Object bookScore;
    //特例参数，图书详情里面星级评定
    private String photo;

    //特例参数，阅读器，开始读书时间
    private long readStime ;
    //特例参数，阅读器,结束读书时间
    private long readEtime ;

    //特例参数，书友会详情里面的书本名称
    private String bookName="";
    //特例参数，搜索图书里面的总得 借阅次数
    private Integer totalLendnum;//总的借阅次数
    //特例参数，搜索图书里面的总得 借阅次数
    private String nickname;//上传书籍的用户名称
    //特例参数，书友会详情里面的图书id
    private Integer slibbookId;//
    //特例参数，书友会详情里面的图书用来删除的id
    private Integer rbookId;//
    //功能参数，用来判断云端是否长按选择
    private boolean isCloudLongCheck=false;


    //功能参数，用来判断下载状态
    private DownloadStateEnum downloadStateEnum = DownloadStateEnum.NUll;
    //功能参数，设置下载进度
    private int downloadProgress=0;
    //功能参数，本地藏书是否选中
    private boolean isLibraryCheck=false;
    //功能参数，搜索 用于判断该书是否属于我自己的书籍
    private boolean isMyBook=false;

    public BookBean() {
    }

    public BookBean(int libbookId) {
        this.libbookId = libbookId;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bId=" + bId +
                ", bookId=" + bookId +
                ", libbookId=" + libbookId +
                ", bookNo='" + bookNo + '\'' +
                ", yyName='" + yyName + '\'' +
                ", yyPublisherId=" + yyPublisherId +
                ", num=" + num +
                ", yyCoverPath='" + yyCoverPath + '\'' +
                ", yyIndexPath='" + yyIndexPath + '\'' +
                ", terminalSn='" + terminalSn + '\'' +
                ", yyFileSize='" + yyFileSize + '\'' +
                ", timeout=" + timeout +
                ", content='" + content + '\'' +
                ", yyFilePath='" + yyFilePath + '\'' +
                ", yyAuthor='" + yyAuthor + '\'' +
                ", downStatus=" + downStatus +
                ", resStatus=" + resStatus +
                ", yyPublisherName='" + yyPublisherName + '\'' +
                ", lendNum=" + lendNum +
                ", lendsDay=" + lendsDay +
                ", accountId=" + accountId +
                ", holdStatus=" + holdStatus +
                ", createTime=" + createTime +
                ", readProgress=" + readProgress +
                ", fileFormat='" + fileFormat + '\'' +
                ", bookType=" + bookType +
                ", status=" + status +
                ", savePath='" + savePath + '\'' +
                ", lastReadTime=" + lastReadTime +
                ", uploadStep=" + uploadStep +
                ", uploadId=" + uploadId +
                ", partInd=" + partInd +
                ", readingLocation=" + readingLocation +
                ", chapterId=" + chapterId +
                ", characterInd=" + characterInd +
                ", elementInd=" + elementInd +
                ", isFirstOpen=" + isFirstOpen +
                ", pubTotal='" + pubTotal + '\'' +
                ", pubNo='" + pubNo + '\'' +
                ", totalWord=" + totalWord +
                ", isbn='" + isbn + '\'' +
                ", sysSeriesId='" + sysSeriesId + '\'' +
                ", isApply=" + isApply +
                ", mylibbookId=" + mylibbookId +
                ", coverPath='" + coverPath + '\'' +
                ", bookScore=" + bookScore +
                ", photo='" + photo + '\'' +
                ", readStime=" + readStime +
                ", readEtime=" + readEtime +
                ", bookName='" + bookName + '\'' +
                ", totalLendnum=" + totalLendnum +
                ", nickname='" + nickname + '\'' +
                ", slibbookId=" + slibbookId +
                ", rbookId=" + rbookId +
                ", isCloudLongCheck=" + isCloudLongCheck +
                ", downloadStateEnum=" + downloadStateEnum +
                ", downloadProgress=" + downloadProgress +
                ", isLibraryCheck=" + isLibraryCheck +
                ", isMyBook=" + isMyBook +
                '}';
    }


    public String getSysSeriesId() {
        return sysSeriesId;
    }

    public void setSysSeriesId(String sysSeriesId) {
        this.sysSeriesId = sysSeriesId;
    }

    public long getReadingLocation() {
        return readingLocation;
    }

    public void setReadingLocation(long readingLocation) {
        this.readingLocation = readingLocation;
    }

    public boolean isFirstOpen() {
        return isFirstOpen;
    }

    public void setFirstOpen(boolean firstOpen) {
        isFirstOpen = firstOpen;
    }
    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public int getLibbookId() {
        return libbookId;
    }

    public void setLibbookId(int libbookId) {
        this.libbookId = libbookId;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getYyName() {
        if(!TextUtils.isEmpty(yyName)){
            return yyName;
        }else return "";
    }

    public void setYyName(String yyName) {
        this.yyName = yyName;
    }

    public Integer getYyPublisherId() {
        return yyPublisherId;
    }

    public void setYyPublisherId(Integer yyPublisherId) {
        this.yyPublisherId = yyPublisherId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getYyCoverPath() {
        return yyCoverPath;
    }

    public void setYyCoverPath(String yyCoverPath) {
        this.yyCoverPath = yyCoverPath;
    }

    public String getYyIndexPath() {
        return yyIndexPath;
    }

    public void setYyIndexPath(String yyIndexPath) {
        this.yyIndexPath = yyIndexPath;
    }

    public String getTerminalSn() {
        return terminalSn;
    }

    public void setTerminalSn(String terminalSn) {
        this.terminalSn = terminalSn;
    }

    public String getYyFileSize() {
        return yyFileSize;
    }

    public void setYyFileSize(String yyFileSize) {
        this.yyFileSize = yyFileSize;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getYyFilePath() {
        return yyFilePath;
    }

    public void setYyFilePath(String yyFilePath) {
        this.yyFilePath = yyFilePath;
    }

    public String getYyAuthor() {
        return yyAuthor;
    }

    public void setYyAuthor(String yyAuthor) {
        this.yyAuthor = yyAuthor;
    }

    public Integer getDownStatus() {
        return downStatus;
    }

    public void setDownStatus(Integer downStatus) {
        this.downStatus = downStatus;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    public String getYyPublisherName() {
        return yyPublisherName;
    }

    public void setYyPublisherName(String yyPublisherName) {
        this.yyPublisherName = yyPublisherName;
    }

    public Integer getLendNum() {
        return lendNum;
    }

    public void setLendNum(Integer lendNum) {
        this.lendNum = lendNum;
    }

    public Integer getLendsDay() {
        return lendsDay;
    }

    public void setLendsDay(Integer lendsDay) {
        this.lendsDay = lendsDay;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getHoldStatus() {
        return holdStatus;
    }

    public void setHoldStatus(Integer holdStatus) {
        this.holdStatus = holdStatus;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public double getReadProgress() {
        return readProgress;
    }

    public void setReadProgress(double readProgress) {
        this.readProgress = readProgress;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public long getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(long lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public Integer getUploadStep() {
        return uploadStep;
    }

    public void setUploadStep(Integer uploadStep) {
        this.uploadStep = uploadStep;
    }

    public Integer getUploadId() {
        return uploadId;
    }

    public void setUploadId(Integer uploadId) {
        this.uploadId = uploadId;
    }

    public long getPartInd() {
        return partInd;
    }

    public void setPartInd(long partInd) {
        this.partInd = partInd;
    }

    public long getChapterId() {
        return chapterId;
    }

    public void setChapterId(long chapterId) {
        this.chapterId = chapterId;
    }

    public long getCharacterInd() {
        return characterInd;
    }

    public void setCharacterInd(long characterInd) {
        this.characterInd = characterInd;
    }

    public long getElementInd() {
        return elementInd;
    }

    public void setElementInd(long elementInd) {
        this.elementInd = elementInd;
    }

    public String getPubTotal() {
        return pubTotal;
    }

    public void setPubTotal(String pubTotal) {
        this.pubTotal = pubTotal;
    }

    public String getPubNo() {
        return pubNo;
    }

    public void setPubNo(String pubNo) {
        this.pubNo = pubNo;
    }

    public double getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(double totalWord) {
        this.totalWord = totalWord;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIsApply() {
        return isApply;
    }

    public void setIsApply(int isApply) {
        this.isApply = isApply;
    }

    public Integer getMylibbookId() {
        return mylibbookId;
    }

    public void setMylibbookId(Integer mylibbookId) {
        this.mylibbookId = mylibbookId;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Object getBookScore() {
        return bookScore;
    }

    public void setBookScore(Object bookScore) {
        this.bookScore = bookScore;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getReadStime() {
        return readStime;
    }

    public void setReadStime(long readStime) {
        this.readStime = readStime;
    }

    public long getReadEtime() {
        return readEtime;
    }

    public void setReadEtime(long readEtime) {
        this.readEtime = readEtime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getTotalLendnum() {
        return totalLendnum;
    }

    public void setTotalLendnum(Integer totalLendnum) {
        this.totalLendnum = totalLendnum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSlibbookId() {
        return slibbookId;
    }

    public void setSlibbookId(Integer slibbookId) {
        this.slibbookId = slibbookId;
    }

    public Integer getRbookId() {
        return rbookId;
    }

    public void setRbookId(Integer rbookId) {
        this.rbookId = rbookId;
    }

    public boolean isCloudLongCheck() {
        return isCloudLongCheck;
    }

    public void setCloudLongCheck(boolean cloudLongCheck) {
        isCloudLongCheck = cloudLongCheck;
    }

    public DownloadStateEnum getDownloadStateEnum() {
        return downloadStateEnum;
    }

    public void setDownloadStateEnum(DownloadStateEnum downloadStateEnum) {
        this.downloadStateEnum = downloadStateEnum;
    }

    public int getDownloadProgress() {
        return downloadProgress;
    }

    public void setDownloadProgress(int downloadProgress) {
        this.downloadProgress = downloadProgress;
    }

    public boolean isLibraryCheck() {
        return isLibraryCheck;
    }

    public void setLibraryCheck(boolean libraryCheck) {
        isLibraryCheck = libraryCheck;
    }

    public boolean isMyBook() {
        return isMyBook;
    }

    public void setMyBook(boolean myBook) {
        isMyBook = myBook;
    }
}
