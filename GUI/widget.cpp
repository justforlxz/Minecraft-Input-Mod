/*
 * Copyright (C) 2017 ~ 2017 Deepin Technology Co., Ltd.
 *
 * Author:     kirigaya <kirigaya@mkacg.com>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

#include "widget.h"

#include <QVBoxLayout>
#include <QLineEdit>
#include <QPushButton>

Widget::Widget(QWidget *parent)
    : DMainWindow(parent)
{
    m_socket = new QUdpSocket(this);

    QVBoxLayout *layout = new QVBoxLayout;
    QWidget *main = new QWidget;
    main->setLayout(layout);

    QLineEdit *edit = new QLineEdit;
    QPushButton *button = new QPushButton("提交");

    layout->addWidget(edit);
    layout->addWidget(button);

    connect(button, &QPushButton::clicked, this, [=] {
        QByteArray datagram = edit->text().toUtf8();
        m_socket->writeDatagram(datagram.data(), datagram.size(),QHostAddress::LocalHost, 36220);
        edit->clear();
    });

    setCentralWidget(main);
}

Widget::~Widget()
{

}
