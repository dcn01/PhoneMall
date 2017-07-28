package com.zhiji.phonemall.data.network.model;

import java.util.List;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
public class TestResponse {

  /**
   * error : false
   * results : [{"_id":"5979848e421aa90ca209c4f7","createdAt":"2017-07-27T14:13:34.914Z","desc":"7-27","publishedAt":"2017-07-27T14:16:33.773Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034ly1fhyeyv5qwkj20u00u0q56.jpg","used":true,"who":"代码家"},{"_id":"597858e3421aa97de5c7c9b5","createdAt":"2017-07-26T16:54:59.321Z","desc":"7-26","publishedAt":"2017-07-26T16:57:39.343Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034ly1fhxe0hfzr0j20u011in1q.jpg","used":true,"who":"daimajia"},{"_id":"59761946421aa90ca209c4d5","createdAt":"2017-07-24T23:59:02.992Z","desc":"7-25","publishedAt":"2017-07-25T15:25:42.391Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034gy1fhvf13o2eoj20u011hjx6.jpg","used":true,"who":"daimajia"}]
   */

  private boolean error;
  private List<ResultsBean> results;

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public List<ResultsBean> getResults() {
    return results;
  }

  public void setResults(List<ResultsBean> results) {
    this.results = results;
  }

  public static class ResultsBean {

    /**
     * _id : 5979848e421aa90ca209c4f7
     * createdAt : 2017-07-27T14:13:34.914Z
     * desc : 7-27
     * publishedAt : 2017-07-27T14:16:33.773Z
     * source : chrome
     * type : 福利
     * url : http://ww1.sinaimg.cn/large/610dc034ly1fhyeyv5qwkj20u00u0q56.jpg
     * used : true
     * who : 代码家
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
      return _id;
    }

    public void set_id(String _id) {
      this._id = _id;
    }

    public String getCreatedAt() {
      return createdAt;
    }

    public void setCreatedAt(String createdAt) {
      this.createdAt = createdAt;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }

    public String getPublishedAt() {
      return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
      this.publishedAt = publishedAt;
    }

    public String getSource() {
      return source;
    }

    public void setSource(String source) {
      this.source = source;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public boolean isUsed() {
      return used;
    }

    public void setUsed(boolean used) {
      this.used = used;
    }

    public String getWho() {
      return who;
    }

    public void setWho(String who) {
      this.who = who;
    }
  }
}
