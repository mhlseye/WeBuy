package com.wyd.domain;
// Generated May 3, 2018 2:37:09 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
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
 * TransPayment generated by hbm2java
 */
@Entity
@Table(name = "trans_payment", catalog = "points")
public class TransPayment implements java.io.Serializable {

	private static final long serialVersionUID = -4254334025353006630L;
	
	private Integer transPaymentId;
	private Company company;
	private PaymentMethod paymentMethod;
	private Status status;
	private TransPayment transPayment;
	private BigDecimal paymentAmt;
	private Date transPaymentDt;
	private String userId;
	private int paymentCurrencyId;
	private String channelCd;
	private Integer batchId;
	private String createdById;
	private Date createdDttm;
	private String lastUpdatedById;
	private Date lastUpdatedDttm;
	private int transPaymentTypeId;
	private Set<TransDetailPayment> transDetailPayments = new HashSet<TransDetailPayment>(0);
	private Set<TransPayment> transPayments = new HashSet<TransPayment>(0);

	public TransPayment() {
	}

	public TransPayment(PaymentMethod paymentMethod, Status status, BigDecimal paymentAmt, Date transPaymentDt,
			int paymentCurrencyId, String channelCd, String createdById, Date createdDttm, String lastUpdatedById,
			Date lastUpdatedDttm, int transPaymentTypeId) {
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paymentAmt = paymentAmt;
		this.transPaymentDt = transPaymentDt;
		this.paymentCurrencyId = paymentCurrencyId;
		this.channelCd = channelCd;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.lastUpdatedById = lastUpdatedById;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.transPaymentTypeId = transPaymentTypeId;
	}

	public TransPayment(Company company, PaymentMethod paymentMethod, Status status, TransPayment transPayment,
			BigDecimal paymentAmt, Date transPaymentDt, String userId, int paymentCurrencyId, String channelCd,
			Integer batchId, String createdById, Date createdDttm, String lastUpdatedById, Date lastUpdatedDttm,
			int transPaymentTypeId, Set<TransDetailPayment> transDetailPayments, Set<TransPayment> transPayments) {
		this.company = company;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.transPayment = transPayment;
		this.paymentAmt = paymentAmt;
		this.transPaymentDt = transPaymentDt;
		this.userId = userId;
		this.paymentCurrencyId = paymentCurrencyId;
		this.channelCd = channelCd;
		this.batchId = batchId;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.lastUpdatedById = lastUpdatedById;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.transPaymentTypeId = transPaymentTypeId;
		this.transDetailPayments = transDetailPayments;
		this.transPayments = transPayments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TRANS_PAYMENT_ID", unique = true, nullable = false)
	public Integer getTransPaymentId() {
		return this.transPaymentId;
	}

	public void setTransPaymentId(Integer transPaymentId) {
		this.transPaymentId = transPaymentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PAYMENT_METHOD_CD", nullable = false)
	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATUS_ID", nullable = false)
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REFERENCE_TRANS_PAYMENT_ID")
	public TransPayment getTransPayment() {
		return this.transPayment;
	}

	public void setTransPayment(TransPayment transPayment) {
		this.transPayment = transPayment;
	}

	@Column(name = "PAYMENT_AMT", nullable = false, precision = 18, scale = 4)
	public BigDecimal getPaymentAmt() {
		return this.paymentAmt;
	}

	public void setPaymentAmt(BigDecimal paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TRANS_PAYMENT_DT", nullable = false, length = 19)
	public Date getTransPaymentDt() {
		return this.transPaymentDt;
	}

	public void setTransPaymentDt(Date transPaymentDt) {
		this.transPaymentDt = transPaymentDt;
	}

	@Column(name = "USER_ID", length = 30)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PAYMENT_CURRENCY_ID", nullable = false)
	public int getPaymentCurrencyId() {
		return this.paymentCurrencyId;
	}

	public void setPaymentCurrencyId(int paymentCurrencyId) {
		this.paymentCurrencyId = paymentCurrencyId;
	}

	@Column(name = "CHANNEL_CD", nullable = false, length = 10)
	public String getChannelCd() {
		return this.channelCd;
	}

	public void setChannelCd(String channelCd) {
		this.channelCd = channelCd;
	}

	@Column(name = "BATCH_ID")
	public Integer getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
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

	@Column(name = "TRANS_PAYMENT_TYPE_ID", nullable = false)
	public int getTransPaymentTypeId() {
		return this.transPaymentTypeId;
	}

	public void setTransPaymentTypeId(int transPaymentTypeId) {
		this.transPaymentTypeId = transPaymentTypeId;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "transPayment")
	@XmlTransient
	public Set<TransDetailPayment> getTransDetailPayments() {
		return this.transDetailPayments;
	}

	public void setTransDetailPayments(Set<TransDetailPayment> transDetailPayments) {
		this.transDetailPayments = transDetailPayments;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "transPayment")
	@XmlTransient
	public Set<TransPayment> getTransPayments() {
		return this.transPayments;
	}

	public void setTransPayments(Set<TransPayment> transPayments) {
		this.transPayments = transPayments;
	}

}
