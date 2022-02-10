package in.as.sixtynine.rakku.entities;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

import static in.as.sixtynine.rakku.constants.DBConstants.RBOX;


@Data
@NoArgsConstructor
@Container(containerName = RBOX)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    private String id;

    @PartitionKey
    private final String type = Product.class.getSimpleName();

    @NotEmpty
    private String itemModelName;
    @NotEmpty
    private String itemColor;
    @NotEmpty
    private String itemSize;
    @NotEmpty
    private double cost;
    @NotEmpty
    private int stock;

    private long createdTime;
    private String createdBy;

    @JsonProperty("_etag")
    private String etag;
    @JsonProperty("_self")
    private String self;
}