package com.krish.type.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krish.type.AbstractHibernateType;
import com.krish.type.json.internal.JsonNodeTypeDescriptor;
import com.krish.type.json.internal.JsonStringSqlTypeDescriptor;
import com.krish.type.util.Configuration;
import com.krish.type.util.ObjectMapperWrapper;

/**
 * Maps a Jackson {@link JsonNode} object on a JSON column type that is managed via {@link java.sql.PreparedStatement#setString(int, String)} at JDBC Driver level. For instance, if you are using MySQL, you should be using {@link JsonNodeStringType} to map the {@code json} column type to a Jackson {@link JsonNode} object.
 * <p>
 * For more details about how to use it, check out <a href="https://vladmihalcea.com/how-to-store-schema-less-eav-entity-attribute-value-data-using-json-and-hibernate/">this article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Vlad Mihalcea
 */
public class JsonNodeStringType extends AbstractHibernateType<JsonNode> {

    public static final JsonNodeStringType INSTANCE = new JsonNodeStringType();

    public JsonNodeStringType() {
        super(
            JsonStringSqlTypeDescriptor.INSTANCE,
            new JsonNodeTypeDescriptor(Configuration.INSTANCE.getObjectMapperWrapper())
        );
    }

    public JsonNodeStringType(Configuration configuration) {
        super(
            JsonStringSqlTypeDescriptor.INSTANCE,
            new JsonNodeTypeDescriptor(configuration.getObjectMapperWrapper()),
            configuration
        );
    }

    public JsonNodeStringType(ObjectMapper objectMapper) {
        super(
            JsonStringSqlTypeDescriptor.INSTANCE,
            new JsonNodeTypeDescriptor(new ObjectMapperWrapper(objectMapper))
        );
    }

    public JsonNodeStringType(ObjectMapperWrapper objectMapperWrapper) {
        super(
            JsonStringSqlTypeDescriptor.INSTANCE,
            new JsonNodeTypeDescriptor(objectMapperWrapper)
        );
    }

    @Override
    public String getName() {
        return "jsonb-node";
    }
}