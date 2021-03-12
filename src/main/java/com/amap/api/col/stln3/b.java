package com.amap.api.col.stln3;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: JSONArray */
public class b extends a implements Serializable, Cloneable, List<Object>, RandomAccess {
    protected transient Object f;
    protected transient Type g;
    private final List<Object> h;

    public b() {
        this.h = new ArrayList(10);
    }

    public b(List<Object> list) {
        this.h = list;
    }

    public b(int i) {
        this.h = new ArrayList(i);
    }

    public final Object b() {
        return this.f;
    }

    public final void c(Object obj) {
        this.f = obj;
    }

    public final Type c() {
        return this.g;
    }

    public final void a(Type type) {
        this.g = type;
    }

    public int size() {
        return this.h.size();
    }

    public boolean isEmpty() {
        return this.h.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.h.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.h.iterator();
    }

    public Object[] toArray() {
        return this.h.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.h.toArray(tArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.h.add(obj);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        return this.h.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.h.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> collection) {
        return this.h.addAll(collection);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends Object> collection) {
        return this.h.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.h.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.h.retainAll(collection);
    }

    public void clear() {
        this.h.clear();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        return this.h.set(i, obj);
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        this.h.add(i, obj);
    }

    @Override // java.util.List
    public Object remove(int i) {
        return this.h.remove(i);
    }

    public int indexOf(Object obj) {
        return this.h.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.h.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.h.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i) {
        return this.h.listIterator(i);
    }

    @Override // java.util.List
    public List<Object> subList(int i, int i2) {
        return this.h.subList(i, i2);
    }

    @Override // java.util.List
    public Object get(int i) {
        return this.h.get(i);
    }

    @Override // java.lang.Object
    public Object clone() {
        return new b(new ArrayList(this.h));
    }

    public boolean equals(Object obj) {
        return this.h.equals(obj);
    }

    public int hashCode() {
        return this.h.hashCode();
    }
}
