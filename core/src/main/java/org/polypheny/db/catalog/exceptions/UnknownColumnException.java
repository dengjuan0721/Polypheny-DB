/*
 * Copyright 2019-2020 The Polypheny Project
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

package org.polypheny.db.catalog.exceptions;


public class UnknownColumnException extends CatalogException {

    public UnknownColumnException( String databaseName, String schemaName, String tableName, String columnName ) {
        super( "There is no column with name '" + columnName + "' in table '" + tableName + "' of schema '" + schemaName + "' in database '" + databaseName + "'" );
    }


    public UnknownColumnException( long tableId, String columnName ) {
        super( "There is no column with name '" + columnName + "' in the table with the id '" + tableId + "'" );
    }

}
