package com.myapp.tenortesttask.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by denishmelinin on 13.03.17.
 */

public class VersionManager {

    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("body")
    @Expose
    private List<Version> versionList = null;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Version> getVersions() {
        return versionList;
    }

    public void setVersions(List<Version> versionList) {
        this.versionList = versionList;
    }

}
