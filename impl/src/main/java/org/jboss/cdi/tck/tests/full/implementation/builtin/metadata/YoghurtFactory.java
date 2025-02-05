/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.cdi.tck.tests.full.implementation.builtin.metadata;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.Bean;

@SuppressWarnings("serial")
@SessionScoped
public class YoghurtFactory implements Serializable {

    private Bean<Yoghurt> fruitYoghurtBean;
    private Bean<Yoghurt> probioticYoghurtBean;

    @Produces
    @Fruit
    public Yoghurt produceFruitYoghurt(Bean<Yoghurt> bean) {
        fruitYoghurtBean = bean;
        return new Yoghurt();
    }

    @Produces
    @Probiotic
    public Yoghurt produceProbioticYoghurt(Bean<Yoghurt> bean) {
        probioticYoghurtBean = bean;
        return new Yoghurt();
    }

    public Bean<?> getFruitYoghurtBean() {
        return fruitYoghurtBean;
    }

    public Bean<?> getProbioticYoghurtBean() {
        return probioticYoghurtBean;
    }

}
