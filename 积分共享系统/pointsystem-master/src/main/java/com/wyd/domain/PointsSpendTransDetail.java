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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * PointsSpendTransDetail generated by hbm2java
 */
@Entity
@Table(name = "points_spend_trans_detail", catalog = "points")
public class PointsSpendTransDetail implements java.io.Serializable {

	private static final long serialVersionUID = -5857773475100720311L;
	
	private Integer pointsSpendTransDetailId;
	private PointsDepositTransDetail pointsDepositTransDetail;
	private PointsTransHeader pointsTransHeader;
	private TransType transType;
	private TransactionDetail transactionDetail;
	private Integer pointsSpendTransQty;
	private String createdById;
	private Date createdDttm;
	private String lastUpdatedById;
	private Date lastUpdatedDttm;
	private Set<PointsDepositTransDetail> pointsDepositTransDetails = new HashSet<PointsDepositTransDetail>(0);

	public PointsSpendTransDetail() {
	}

	public PointsSpendTransDetail(PointsDepositTransDetail pointsDepositTransDetail,
			PointsTransHeader pointsTransHeader, TransType transType, String createdById, Date createdDttm,
			String lastUpdatedById, Date lastUpdatedDttm) {
		this.pointsDepositTransDetail = pointsDepositTransDetail;
		this.pointsTransHeader = pointsTransHeader;
		this.transType = transType;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.lastUpdatedById = lastUpdatedById;
		this.lastUpdatedDttm = lastUpdatedDttm;
	}

	public PointsSpendTransDetail(PointsDepositTransDetail pointsDepositTransDetail,
			PointsTransHeader pointsTransHeader, TransType transType, TransactionDetail transactionDetail,
			Integer pointsSpendTransQty, String createdById, Date createdDttm, String lastUpdatedById,
			Date lastUpdatedDttm, Set<PointsDepositTransDetail> pointsDepositTransDetails) {
		this.pointsDepositTransDetail = pointsDepositTransDetail;
		this.pointsTransHeader = pointsTransHeader;
		this.transType = transType;
		this.transactionDetail = transactionDetail;
		this.pointsSpendTransQty = pointsSpendTransQty;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.lastUpdatedById = lastUpdatedById;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.pointsDepositTransDetails = pointsDepositTransDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "POINTS_SPEND_TRANS_DETAIL_ID", unique = true, nullable = false)
	public Integer getPointsSpendTransDetailId() {
		return this.pointsSpendTransDetailId;
	}

	public void setPointsSpendTransDetailId(Integer pointsSpendTransDetailId) {
		this.pointsSpendTransDetailId = pointsSpendTransDetailId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "POINTS_DEPOSIT_TRANS_DETAIL_ID", nullable = false)
	public PointsDepositTransDetail getPointsDepositTransDetail() {
		return this.pointsDepositTransDetail;
	}

	public void setPointsDepositTransDetail(PointsDepositTransDetail pointsDepositTransDetail) {
		this.pointsDepositTransDetail = pointsDepositTransDetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "POINTS_TRANS_HEADER_ID", nullable = false)
	public PointsTransHeader getPointsTransHeader() {
		return this.pointsTransHeader;
	}

	public void setPointsTransHeader(PointsTransHeader pointsTransHeader) {
		this.pointsTransHeader = pointsTransHeader;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TRANS_TYPE_ID", nullable = false)
	public TransType getTransType() {
		return this.transType;
	}

	public void setTransType(TransType transType) {
		this.transType = transType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TRANSACTION_ID")
	public TransactionDetail getTransactionDetail() {
		return this.transactionDetail;
	}

	public void setTransactionDetail(TransactionDetail transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	@Column(name = "POINTS_SPEND_TRANS_QTY")
	public Integer getPointsSpendTransQty() {
		return this.pointsSpendTransQty;
	}

	public void setPointsSpendTransQty(Integer pointsSpendTransQty) {
		this.pointsSpendTransQty = pointsSpendTransQty;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pointsSpendTransDetail")
	@XmlTransient
	public Set<PointsDepositTransDetail> getPointsDepositTransDetails() {
		return this.pointsDepositTransDetails;
	}

	public void setPointsDepositTransDetails(Set<PointsDepositTransDetail> pointsDepositTransDetails) {
		this.pointsDepositTransDetails = pointsDepositTransDetails;
	}

}
