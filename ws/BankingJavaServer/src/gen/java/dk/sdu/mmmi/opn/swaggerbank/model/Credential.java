package dk.sdu.mmmi.opn.swaggerbank.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Credentials used to login a user and retrieve account information
 **/

/**
 * Credentials used to login a user and retrieve account information
 */
@ApiModel(description = "Credentials used to login a user and retrieve account information")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-04T09:28:53.557+02:00")
public class Credential   {
  private String name = null;

  private Integer id = null;

  public Credential name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Gets the name of the user
   * @return name
  **/
  @ApiModelProperty(value = "Gets the name of the user")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Credential id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Gets the ID of the user
   * @return id
  **/
  @ApiModelProperty(value = "Gets the ID of the user")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Credential credential = (Credential) o;
    return Objects.equals(this.name, credential.name) &&
        Objects.equals(this.id, credential.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Credential {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

