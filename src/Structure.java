




import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for structure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="structure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}String"/>
 *         &lt;element name="atlas-id" type="{http://www.w3.org/2001/XMLSchema}String"/>
 *         &lt;element name="ontology-id" type="{http://www.w3.org/2001/XMLSchema}String"/>
 *         &lt;element name="acronym" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="color-hex-triplet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="graph-order" type="{http://www.w3.org/2001/XMLSchema}String"/>
 *         &lt;element name="st-level" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hemisphere-id" type="{http://www.w3.org/2001/XMLSchema}String"/>
 *         &lt;element name="parent-structure-id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="children" type="{}children"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "structure", propOrder = {
    "id",
    "atlasId",
    "ontologyId",
    "acronym",
    "name",
    "colorHexTriplet",
    "graphOrder",
    "stLevel",
    "hemisphereId",
    "parentStructureId",
    "children"
})
public class Structure {

    protected String id;
    protected String atlasId;
    protected String ontologyId;
    protected String acronym;
    protected String name;
    protected String colorHexTriplet;
    protected String colorR;
    protected String colorG;
    protected String colorB;
    protected String graphOrder;
    protected String stLevel;
    protected String hemisphereId;
    protected String parentStructureId;
    protected List<Structure> children= new ArrayList<Structure>();
    protected String graylevel;
	protected String structureNameKey;
	protected String edinburghKey;
	protected String treeDepth;
	protected String printStop;
	protected String topoSort;
	protected String structureNote;
	protected XMLGregorianCalendar creationDate;
	protected XMLGregorianCalendar modificationDate;

    
    /**
     * Gets the value of the id property.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the atlasId property.
     * 
     */
    public String getAtlasId() {
        return atlasId;
    }

    /**
     * Sets the value of the atlasId property.
     * 
     */
    public void setAtlasId(String value) {
        this.atlasId = value;
    }

    /**
     * Gets the value of the ontologyId property.
     * 
     */
    public String getOntologyId() {
        return ontologyId;
    }

    /**
     * Sets the value of the ontologyId property.
     * 
     */
    public void setOntologyId(String value) {
        this.ontologyId = value;
    }

    /**
     * Gets the value of the acronym property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Sets the value of the acronym property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcronym(String value) {
        this.acronym = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the colorHexTriplet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorHexTriplet() {
        return colorHexTriplet;
    }

    /**
     * Sets the value of the colorHexTriplet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorHexTriplet(String value) {
        this.colorHexTriplet = value;
    }

    /**
     * Gets the value of the graphOrder property.
     * 
     */
    public String getGraphOrder() {
        return graphOrder;
    }

    /**
     * Sets the value of the graphOrder property.
     * 
     */
    public void setGraphOrder(String value) {
        this.graphOrder = value;
    }

    /**
     * Gets the value of the stLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStLevel() {
        return stLevel;
    }

    /**
     * Sets the value of the stLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStLevel(String value) {
        this.stLevel = value;
    }

    /**
     * Gets the value of the hemisphereId property.
     * 
     */
    public String getHemisphereId() {
        return hemisphereId;
    }

    /**
     * Sets the value of the hemisphereId property.
     * 
     */
    public void setHemisphereId(String value) {
        this.hemisphereId = value;
    }

    /**
     * Gets the value of the parentStructureId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentStructureId() {
        return parentStructureId;
    }

    /**
     * Sets the value of the parentStructureId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentStructureId(String value) {
        this.parentStructureId = value;
    }

    /**
     * Gets the value of the children property.
     * 
     * @return
     *     possible object is
     *     {@link Children }
     *     
     */
    public List<Structure> getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     * @param value
     *     allowed object is
     *     {@link Children }
     *     
     */
    public void addChild(Structure value) {
        this.children.add(value);
    }
    
    public void addChildren(ArrayList<Structure> newchildren)
    {
    	this.children.addAll(newchildren);
    }
    
    public String getGrayLevel() {
    	return graylevel;
    }
    
    public void setGrayLevel(String value){
    	this.graylevel = value;
    }
   //
    
    
    
    
	/**
	 * Gets the value of the structureNameKey property.
	 * 
	 */
	public String getStructureNameKey() {
		return structureNameKey;
	}

	/**
	 * Sets the value of the structureNameKey property.
	 * 
	 */
	public void setStructureNameKey(String value) {
		this.structureNameKey = value;
	}

	/**
	 * Gets the value of the edinburghKey property.
	 * 
	 */
	public String getEdinburghKey() {
		return edinburghKey;
	}

	/**
	 * Sets the value of the edinburghKey property.
	 * 
	 */
	public void setEdinburghKey(String value) {
		this.edinburghKey = value;
	}

	/**
	 * Gets the value of the treeDepth property.
	 * 
	 */
	public String getTreeDepth() {
		return treeDepth;
	}

	/**
	 * Sets the value of the treeDepth property.
	 * 
	 */
	public void setTreeDepth(String value) {
		this.treeDepth = value;
	}

	/**
	 * Gets the value of the printStop property.
	 * 
	 */
	public String getPrintStop() {
		return printStop;
	}

	/**
	 * Sets the value of the printStop property.
	 * 
	 */
	public void setPrintStop(String value) {
		this.printStop = value;
	}

	/**
	 * Gets the value of the topoSort property.
	 * 
	 */
	public String getTopoSort() {
		return topoSort;
	}

	/**
	 * Sets the value of the topoSort property.
	 * 
	 */
	public void setTopoSort(String value) {
		this.topoSort = value;
	}

	/**
	 * Gets the value of the structureNote property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getStructureNote() {
		return structureNote;
	}

	/**
	 * Sets the value of the structureNote property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setStructureNote(String value) {
		this.structureNote = value;
	}

	/**
	 * Gets the value of the creationDate property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public XMLGregorianCalendar getCreationDate() {
		return creationDate;
	}

	

	/**
	 * Sets the value of the creationDate property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public void setCreationDate(XMLGregorianCalendar value) {
		this.creationDate = value;
	}

	/**
	 * Gets the value of the modificationDate property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public XMLGregorianCalendar getModificationDate() {
		return modificationDate;
	}

	/**
	 * Sets the value of the modificationDate property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public void setModificationDate(XMLGregorianCalendar value) {
		this.modificationDate = value;
	}
	public boolean isChild(Structure parent)
	{
		if(getParentStructureId().equals(parent.getId()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
     * Gets the value of the colorHexTriplet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorB() {
        return colorB;
    }

    /**
     * Sets the value of the colorHexTriplet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorB(String value) {
        this.colorB = value;
    }
    /**
     * Gets the value of the colorHexTriplet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorGt() {
        return colorG;
    }

    /**
     * Sets the value of the colorHexTriplet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorG(String value) {
        this.colorG = value;
    }
    /**
     * Gets the value of the colorHexTriplet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorR() {
        return colorR;
    }

    /**
     * Sets the value of the colorHexTriplet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorR(String value) {
        this.colorR = value;
    }

}