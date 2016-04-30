package com.careydevelopment.bargaintower.jpa.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.careydevelopment.bargaintower.util.SiteConstants;
import com.careydevelopment.bargaintower.util.SlugMaker;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity{
	
	@Column(name="name")
	private String name = "";
	
	@Column(name="program_name")
	private String programName = "";
	
	@Column(name="program_url")
	private String programUrl = "";
	
	@Column(name="catalog_name")
	private String catalogName = "";
	
	@Column(name="description")
	private String description = "";
	
	@Column(name="sku")
	private String sku = "";
	
	@Column(name="vendor")
	private String vendor = "";
	
	@Column(name="upc")
	private String upc = "";
	
	@Column(name="price")
	private String price = "";
	
	@Column(name="buy_url")
	private String buyUrl = "";
	
	@Column(name="manufacturer")
	private String manufacturerId = "";
	
	@Column(name="impression_url")
	private String impressionUrl = "";
	
	@JoinColumn(name = "category_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Category advertiserCategory;
	
	@Column(name="in_stock")
	private String inStock = "";
	
	@Column(name="retail_price")
	private String retailPrice =  "";
	
	@Column(name="image_url")
	private String imageUrl = "";
	

	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_attribute",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_value_id")
    )
	private List<AttributeValue> attributes = new ArrayList<AttributeValue>();
	
	@Transient
	private boolean moreColors = false;
	 
	@Transient
	private List<String> sizes = new ArrayList<String>();
	
	@Transient
	private List<String> colors = new ArrayList<String>();
	
	@Transient
	private String artist = "";
	
	@Transient
	private String height = "";
	
	@Transient
	private String width = "";
	
	@Transient
	private String length = "";
	
	@Transient
	private String weight = "";
	
	@Transient
	private String lowestOfferPrice = "";
	
	@Transient
	private String offersUrl = "";
	
	@Transient
	private List<String> variantFrontUrls = new ArrayList<String>();
	
	@Transient
	private List<String> variantBackUrls = new ArrayList<String>();
	
	@Transient
	private List<String> swatchUrls = new ArrayList<String>();	
	
	@Transient
	private Map<String,String> attMap = new HashMap<String,String>();
	
	@Transient
	private boolean onSale = false;
	
	
	public List<String> getSizes() {
		if (sizes.size() == 0) {
			for (AttributeValue val : attributes) {
				if (val.getAttribute().getName().equalsIgnoreCase("Size")) {
					sizes.add(val.getName());
				}
			}
		}
		
		return sizes;
	}

	public List<String> getColors() {
		if (colors.size() == 0) {
			for (AttributeValue val : attributes) {
				if (val.getAttribute().getName().equalsIgnoreCase("Color")) {
					colors.add(val.getName());
				}
			}
		}
		
		return colors;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getInStock() {
		return inStock;
	}
	public void setInStock(String inStock) {
		this.inStock = inStock;
	}
	public String getName() {
		if (name != null && name.length() > SiteConstants.MAX_PRODUCT_NAME_LENGTH) {
			name = name.substring(0, SiteConstants.MAX_PRODUCT_NAME_LENGTH - 3) + "...";
		}
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramUrl() {
		return programUrl;
	}
	public void setProgramUrl(String programUrl) {
		this.programUrl = programUrl;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getPrice() {
		return price;
	}
	
	public String getPriceCurrency() {
		return "$" + price;
	}
	
	public void setPrice(String price) {
		/*System.err.println("setting price to " + price);
		try {
			throw new Exception ("HITIE");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		this.price = price;
	}
	public String getBuyUrl() {
		return buyUrl;
	}
	public void setBuyUrl(String buyUrl) {
		this.buyUrl = buyUrl;
	}
	public String getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public String getImpressionUrl() {
		return impressionUrl;
	}
	public void setImpressionUrl(String impressionUrl) {
		this.impressionUrl = impressionUrl;
	}
	public Category getAdvertiserCategory() {
		return advertiserCategory;
	}
	public void setAdvertiserCategory(Category advertiserCategory) {
		this.advertiserCategory = advertiserCategory;
	}

	public List<String> getVariantFrontUrls() {
		return variantFrontUrls;
	}
	public void setVariantFrontUrls(List<String> variantFrontUrls) {
		this.variantFrontUrls = variantFrontUrls;
	}
	public List<String> getVariantBackUrls() {
		return variantBackUrls;
	}
	public void setVariantBackUrls(List<String> variantBackUrls) {
		this.variantBackUrls = variantBackUrls;
	}
	public List<String> getSwatchUrls() {
		return swatchUrls;
	}
	public void setSwatchUrls(List<String> swatchUrls) {
		this.swatchUrls = swatchUrls;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getLowestOfferPrice() {
		return lowestOfferPrice;
	}
	public void setLowestOfferPrice(String lowestOfferPrice) {
		this.lowestOfferPrice = lowestOfferPrice;
	}
	public String getOffersUrl() {
		return offersUrl;
	}
	public void setOffersUrl(String offersUrl) {
		this.offersUrl = offersUrl;
	}
	public Map<String, String> getAttMap() {
		return attMap;
	}
	public void setAttMap(Map<String, String> attMap) {
		this.attMap = attMap;
	}
	public List<AttributeValue> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<AttributeValue> attributes) {
		this.attributes = attributes;
	}
	public boolean isOnSale() {
		if (price == null || retailPrice == null) return false;
		
		try {
			Float priceF = new Float(price);
			Float retailPriceF = new Float(retailPrice);
			
			if (retailPriceF > priceF) {
				return true;
			}	
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		}
		
		return onSale;
	}
	
	public boolean isMoreColors() {
		int numColors = 0;
		
		for (AttributeValue av : attributes) {
			if (av.getAttribute().getName().equalsIgnoreCase("Color")) {
				numColors++;
				if (numColors > 1) break;
			}
		}
		
		return (numColors > 1);
	}
	
	
	public String getProductUrl() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("/product/");
		builder.append(id);
		builder.append("-");

		String slug = SlugMaker.makeSlug(name);
		builder.append(slug);
		
		return builder.toString();
	}
	
}
