package com.testvagrant.ekamTemplate.mobile.workflows;

public interface Workflow<Layout, Next> {

    Layout create();

    Next next();
}
