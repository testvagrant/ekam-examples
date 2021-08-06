package com.testvagrant.ekamexamples.workflows;

public interface Workflow<Layout, Next> {

  Layout create();

  Next next();
}
