package io.searchbox.core;

import com.google.gson.JsonObject;
import io.searchbox.action.GenericResultAbstractDocumentTargetedAction;


/**
 * @author Dogukan Sonmez
 * @author cihat keser
 */
public class Get extends GenericResultAbstractDocumentTargetedAction {

    private Get(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    @Override
    public String getPathToResult() {
        return "_source";
    }

    @Override
    public Boolean isOperationSucceed(JsonObject result) {
        //TODO we need to check the http header
        //return result.get("exists").getAsBoolean();
        return true;
    }

    public static class Builder extends GenericResultAbstractDocumentTargetedAction.Builder<Get, Builder> {

        /**
         * Index and ID parameters are mandatory but type is optional (_all will be used for type if left blank).
         * <br/><br/>
         * The get API allows for _type to be optional. Set it to _all in order to fetch the
         * first document matching the id across all types.
         */
        public Builder(String index, String id) {
            this.index(index);
            this.id(id);
            this.type("_all");
        }

        public Get build() {
            return new Get(this);
        }
    }
}
