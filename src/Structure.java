import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
public class Structure {

    public String id;
    public String atlasId;
    public String ontologyId;
    public String acronym;
    public String name;
    public String colorHexTriplet;
    public String colorR;
    public String colorG;
    public String colorB;
    public String graphOrder;
    public String stLevel;
    public String hemisphereId;
    public String parentStructureId;
    public List<Structure> children= new ArrayList<Structure>();
    public String graylevel;
	public String structureNameKey;
	public String edinburghKey;
	public String treeDepth;
	public String printStop;
	public String topoSort;
	public String structureNote;
	public XMLGregorianCalendar creationDate;
	public XMLGregorianCalendar modificationDate;

	public Structure(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Structure(){
		
	}
    
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