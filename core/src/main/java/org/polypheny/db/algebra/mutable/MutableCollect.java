/*
 * Copyright 2019-2021 The Polypheny Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file incorporates code covered by the following terms:
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.polypheny.db.algebra.mutable;


import java.util.Objects;
import org.polypheny.db.algebra.type.AlgDataType;


/**
 * Mutable equivalent of {@link org.polypheny.db.algebra.core.Collect}.
 */
public class MutableCollect extends MutableSingleAlg {

    public final String fieldName;


    private MutableCollect( AlgDataType rowType, MutableAlg input, String fieldName ) {
        super( MutableAlgType.COLLECT, rowType, input );
        this.fieldName = fieldName;
    }


    /**
     * Creates a MutableCollect.
     *
     * @param rowType Row type
     * @param input Input relational expression
     * @param fieldName Name of the sole output field
     */
    public static MutableCollect of( AlgDataType rowType, MutableAlg input, String fieldName ) {
        return new MutableCollect( rowType, input, fieldName );
    }


    @Override
    public boolean equals( Object obj ) {
        return obj == this
                || obj instanceof MutableCollect
                && fieldName.equals( ((MutableCollect) obj).fieldName )
                && input.equals( ((MutableCollect) obj).input );
    }


    @Override
    public int hashCode() {
        return Objects.hash( input, fieldName );
    }


    @Override
    public StringBuilder digest( StringBuilder buf ) {
        return buf.append( "Collect(fieldName: " ).append( fieldName ).append( ")" );
    }


    @Override
    public MutableAlg clone() {
        return MutableCollect.of( rowType, input.clone(), fieldName );
    }

}

