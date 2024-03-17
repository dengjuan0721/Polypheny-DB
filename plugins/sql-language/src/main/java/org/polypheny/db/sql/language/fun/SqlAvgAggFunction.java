/*
 * Copyright 2019-2023 The Polypheny Project
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
 */

package org.polypheny.db.sql.language.fun;


import com.google.common.base.Preconditions;
import org.polypheny.db.algebra.constant.FunctionCategory;
import org.polypheny.db.algebra.constant.Kind;
import org.polypheny.db.sql.language.SqlAggFunction;
import org.polypheny.db.type.checker.OperandTypes;
import org.polypheny.db.type.inference.ReturnTypes;
import org.polypheny.db.util.Optionality;


/**
 * <code>Avg</code> is an aggregator which returns the average of the values which go into it. It has precisely one argument of numeric type
 * (<code>int</code>, <code>long</code>, <code>float</code>, <code>double</code>), and the result is the same type.
 */
public class SqlAvgAggFunction extends SqlAggFunction {


    /**
     * Creates a SqlAvgAggFunction.
     */
    public SqlAvgAggFunction( Kind kind ) {
        this( kind.name(), kind );
    }


    public SqlAvgAggFunction( String name, Kind kind ) {
        super(
                name,
                null,
                kind,
                ReturnTypes.AVG_AGG_FUNCTION,
                null,
                OperandTypes.NUMERIC,
                FunctionCategory.NUMERIC,
                false,
                false,
                Optionality.FORBIDDEN );
        Preconditions.checkArgument( Kind.AVG_AGG_FUNCTIONS.contains( kind ), "unsupported sql kind" );
    }

}

