package com.wyd.domain;
// Generated May 3, 2018 2:37:09 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "trans_type", catalog = "points", uniqueConstraints = @UniqueConstraint(columnNames = { "TRANS_TYPE_CD",
		"CAT_CD" }))
public class TransType implements java.io.Serializable {

	private static final long serialVersionUID = -7338170521750156812L;
	
	private Integer transTypeId;
	private String transTypeCd;
	private String transTypeDesc;
	private String catCd;
	private String lastUpdatedById;
	private Date lastUpdatedDttm;
	private int activeInd;
	private String createdById;
	private Date createdDttm;
	private Set<PointsDepositTransDetail> pointsDepositTransDetails = new HashSet<PointsDepositTransDetail>(0);
	private Set<PointsSpendTransDetail> pointsSpendTransDetails = new HashSet<PointsSpendTransDetail>(0);
	private Set<TransactionDetail> transactionDetails = new HashSet<TransactionDetail>(0);

	public TransType() {
	}

	public TransType(String transTypeCd, String catCd, String lastUpdatedById, Date lastUpdatedDttm, int activeInd,
			String createdById, Date createdDttm) {
		this.transTypeCd = transTypeCd;
		this.catCd = catCd;
		this.lastUpdatedById = lastUpdatedById;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.activeInd = activeInd;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
	}

	public TransType(String transTypeCd, String transTypeDesc, String catCd, String lastUpdatedById,
			Date lastUpdatedDttm, int activeInd, String createdById, Date createdDttm,
			Set<PointsDepositTransDetail> pointsDepositTransDetails,
			Set<PointsSpendTransDetail> pointsSpendTransDetails, Set<TransactionDetail> transactionDetails) {
		this.transTypeCd = transTypeCd;
		this.transTypeDesc = transTypeDesc;
		this.catCd = catCd;
		this.lastUpdatedById = lastUpdatedById;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.activeInd = activeInd;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.pointsDepositTransDetails = pointsDepositTransDetails;
		this.pointsSpendTransDetails = pointsSpendTransDetails;
		this.transactionDetails = transactionDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TRANS_TYPE_ID", unique = true, nullable = false)
	public Integer getTransTypeId() {
		return this.transTypeId;
	}

	public void setTransTypeId(Integer transTypeId) {
		this.transTypeId = transTypeId;
	}

	@Column(name = "TRANS_TYPE_CD", nullable = false, length = 10)
	public String getTransTypeCd() {
		return this.transTypeCd;
	}

	public void setTransTypeCd(String transTypeCd) {
		this.transTypeCd = transTypeCd;
	}

	@Column(name = "TRANS_TYPE_DESC", length = 100)
	public String getTransTypeDesc() {
		return this.transTypeDesc;
	}

	public void setTransTypeDesc(String transTypeDesc) {
		this.transTypeDesc = transTypeDesc;
	}

	@Column(name = "CAT_CD", nullable = false, length = 10)
	public String getCatCd() {
		return this.catCd;
	}

	public void setCatCd(String catCd) {
		this.catCd = catCd;
	}

	@Column(name = "LAST_UPDATED_BY_ID", nullable = false, length = 100)
	public String getLastUpdatedById() {
		return this.lastUpdatedById;
	}

	public void setLastUpdatedById(String lastUpdatedById) {
		this.lastUpdatedById = lastUpdatedById;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DTTM", nullable = false, length = 19)
	public Date getLastUpdatedDttm() {
		return this.lastUpdatedDttm;
	}

	public void setLastUpdatedDttm(Date lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}

	@Column(name = "ACTIVE_IND", nullable = false)
	public int getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(int activeInd) {
		this.activeInd = activeInd;
	}

	@Column(name = "CREATED_BY_ID", nullable = false, length = 100)
	public String getCreatedById() {
		return this.createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DTTM", nullable = false, length = 19)
	public Date getCreatedDttm() {
		return this.createdDttm;
	}

	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "transType")
	@XmlTransient
	public Set<PointsDepositTransDetail> getPointsDepositTransDetails() {
		return this.pointsDepositTransDetails;
	}

	public void setPointsDepositTransDetails(Set<PointsDepositTransDetail> pointsDepositTransDetails) {
		this.pointsDepositTransDetails = pointsDepositTransDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "transType")
	@XmlTransient
	public Set<PointsSpendTransDetail> getPointsSpendTransDetails() {
		return this.pointsSpendTransDetails;
	}

	public void setPointsSpendTransDetails(Set<PointsSpendTransDetail> pointsSpendTransDetails) {
		this.pointsSpendTransDetails = pointsSpendTransDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "transType")
	@XmlTransient
	public Set<TransactionDetail> getTransactionDetails() {
		return this.transactionDetails;
	}

	public void setTransactionDetails(Set<TransactionDetail> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}
