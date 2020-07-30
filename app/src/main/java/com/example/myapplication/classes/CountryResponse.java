package com.example.myapplication.classes;

import com.google.gson.annotations.SerializedName;

public class CountryResponse {
    @SerializedName("total_count")
    private long totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteRequests;

    @SerializedName("items")
    private CountryItem repoItems;

//    public List<CountryItem> getRepoItems() {
////        return repoItems;
////    }

    public CountryItem getRepoItems() {
        return repoItems;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public boolean isIncompleteRequests() {
        return incompleteRequests;
    }

    public void setIncompleteRequests(boolean incompleteRequests) {
        this.incompleteRequests = incompleteRequests;
    }

//    public void setRepoItems(List<CountryItem> repoItems) {
//        this.repoItems = repoItems;
//    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

}
