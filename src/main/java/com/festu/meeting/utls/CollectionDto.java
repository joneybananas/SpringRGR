//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.festu.meeting.utls;

import java.beans.ConstructorProperties;
import java.util.Collections;
import java.util.List;

public class CollectionDto<T> {
    private List<T> items;
    private long totalCount;

    public CollectionDto() {
        this.items = Collections.emptyList();
        this.totalCount = 0L;
    }

    public CollectionDto(List<T> items) {
        this.items = items;
        this.totalCount = (long)items.size();
    }

    public static <T> CollectionDto<T> empty() {
        return new CollectionDto();
    }

    public List<T> getItems() {
        return this.items;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CollectionDto)) {
            return false;
        } else {
            CollectionDto<?> other = (CollectionDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items == null) {
                        return this.getTotalCount() == other.getTotalCount();
                    }
                } else if (this$items.equals(other$items)) {
                    return this.getTotalCount() == other.getTotalCount();
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CollectionDto;
    }

    public String toString() {
        return "CollectionDto(items=" + this.getItems() + ", totalCount=" + this.getTotalCount() + ")";
    }

    @ConstructorProperties({"items", "totalCount"})
    public CollectionDto(List<T> items, long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }
}
