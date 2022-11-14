package com.example.dependencyinversionprinciple.presentation.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinversionprinciple.databinding.ItemAccountBinding
import com.example.dependencyinversionprinciple.presentation.model.home.AccountModel

class HomeAccountInformationAdapter(
    private val accountList: List<AccountModel>,
    private val listener: (accountSelected: AccountModel) -> Unit = { }
) : RecyclerView.Adapter<HomeAccountInformationAdapter.AccountInformationViewHolder>() {

    class AccountInformationViewHolder(
        val view: ItemAccountBinding,
        private val listener: (accountSelected: AccountModel) -> Unit = { }
    ) : RecyclerView.ViewHolder(view.root) {
        fun onBind(data: AccountModel) {
            with(view) {
                ivArrow.setOnClickListener {
                    listener(data)
                }
                tvItemAccountName.text = data.productName
                tvItemLastDigits.text = data.lastDigits
            }

        }

        companion object {
            @JvmStatic
            fun build(
                parent: ViewGroup,
                listener: (accountSelected: AccountModel) -> Unit = { }
            ): AccountInformationViewHolder {
                return AccountInformationViewHolder(
                    ItemAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                    listener
                )
            }
        }
    }

    override fun getItemCount(): Int = accountList.size

    override fun onBindViewHolder(holder: AccountInformationViewHolder, position: Int) {
        holder.onBind(accountList[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountInformationViewHolder {
        return AccountInformationViewHolder.build(parent, listener)
    }
}