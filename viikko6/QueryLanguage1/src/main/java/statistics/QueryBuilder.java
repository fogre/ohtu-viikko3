/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.*;

/**
 *
 * @author ajkotira
 */
public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new And();
    }

    public Matcher build() {
        return matcher;
    }

    QueryBuilder playsIn(String s) {
        this.matcher = new And(matcher, new PlaysIn(s));
        return this;
    }

    QueryBuilder hasAtLeast(int n, String s) {
        this.matcher = new And(matcher, new HasAtLeast(n, s));
        return this;
    }

    QueryBuilder hasFewerThan(int n, String s) {
        this.matcher = new And(matcher, new HasFewerThan(n, s));
        return this;
    }
    
    QueryBuilder not(Matcher match) {
        this.matcher = new And(matcher, new Not(match));
        return this;
    }
    
    QueryBuilder oneOf(Matcher match, Matcher match2) {
        this.matcher = new Or(match, match2);
        return this;
    }

}
